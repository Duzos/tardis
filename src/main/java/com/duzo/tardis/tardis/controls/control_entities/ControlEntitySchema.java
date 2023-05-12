package com.duzo.tardis.tardis.controls.control_entities;

import com.duzo.tardis.core.util.AbsoluteBlockPos;
import com.duzo.tardis.network.Network;
import com.duzo.tardis.network.packets.UpdateLeverPulledS2CPacket;
import com.duzo.tardis.tardis.TARDIS;
import com.duzo.tardis.tardis.consoles.blocks.entities.ConsoleBlockEntity;
import com.duzo.tardis.tardis.io.TARDISTravel;
import com.duzo.tardis.tardis.manager.TARDISManager;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ambient.AmbientCreature;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.UUID;

public abstract class ControlEntitySchema extends AmbientCreature {

    private static final EntityDataAccessor<Byte> DATA_ID_FLAGS = SynchedEntityData.defineId(ControlEntitySchema.class, EntityDataSerializers.BYTE);
    private static final EntityDataAccessor<String> CONTROL_NAME = SynchedEntityData.defineId(ControlEntitySchema.class, EntityDataSerializers.STRING);

    protected BlockPos consolePosition;
    public static float sizing = 0.125f;
    public static boolean hasBeenHit = false;
    protected float x;
    protected float y;
    protected float z;
    protected int incrementValue = 1;
    public boolean isPulled;
    public UUID tardisID;

    public ControlEntitySchema(EntityType<? extends AmbientCreature> p_i50290_1_, Level p_i50290_2_) {
        super(p_i50290_1_, p_i50290_2_);
    }

    public ControlEntitySchema(EntityType<? extends AmbientCreature> entity, Level level, UUID tardisID, String name, BlockPos consoleBlockPos) {
        super(entity, level);
        this.tardisID = tardisID;
        this.setControlName(name);
        this.setListedPosition(tardisID, TARDISManager.getInstance().findTARDIS(tardisID).getPosition());
        this.consolePosition = consoleBlockPos;
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.entityData.set(DATA_ID_FLAGS, pCompound.getByte("ControlFlags"));
        this.setControlName(pCompound.getString("customName"));
        this.hasBeenHit = pCompound.getBoolean("hasbeenhit");
        if (this.tardisID != null) {
            this.tardisID = pCompound.getUUID("tardisID");
        }
        this.x = pCompound.getFloat("x");
        this.y = pCompound.getFloat("y");
        this.z = pCompound.getFloat("z");
        this.incrementValue = pCompound.getInt("increment");
        /*this.consolePosition = new BlockPos(pCompound.getInt("consolePositionX"),
                pCompound.getInt("consolePositionY"), pCompound.getInt("consolePositionZ"));*/
        this.consolePosition = NbtUtils.readBlockPos(pCompound.getCompound("consolePosition"));
        /*if(this.getCustomName().getContents().equals("Dimension Switch") && this.tardisID != null) {
            this.currentdimensionstate = EnumDimensionControlState.values()[pCompound.getInt("currentdimensionstate")];
        }
        if(this.getCustomName().getContents().equals("Exterior Facing") && this.tardisID != null) {
            this.currentExteriorFacingSetting = EnumExteriorFacingState.values()[pCompound.getInt("exteriorfacing")];
        }*/
    }

    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putByte("ControlFlags", this.entityData.get(DATA_ID_FLAGS));
        pCompound.putString("customName",this.getControlName());
        pCompound.putBoolean("hasbeenhit", this.hasBeenHit);
        if (this.tardisID != null) {
            pCompound.putUUID("tardisID", this.tardisID);
        }
        pCompound.putFloat("x", this.x);
        pCompound.putFloat("y", this.y);
        pCompound.putFloat("z", this.z);
        pCompound.putInt("increment", this.incrementValue);
        if(this.consolePosition != null) {
            /*pCompound.putInt("consolePositionX", this.consolePosition.getX());
            pCompound.putInt("consolePositionY", this.consolePosition.getY());
            pCompound.putInt("consolePositionZ", this.consolePosition.getZ());*/
            pCompound.put("consolePosition", NbtUtils.writeBlockPos(this.consolePosition));
        }
        /*if(this.getCustomName().getContents().equals("Dimension Switch") && this.tardisID != null) {
            pCompound.putInt("currentdimensionstate", this.currentdimensionstate.ordinal());
        }
        if(this.getCustomName().getContents().equals("Exterior Facing") && this.tardisID != null) {
            pCompound.putInt("exteriorfacing", this.currentExteriorFacingSetting.ordinal());
        }*/
    }

    public void setControlName(String newControlName) {
        this.setCustomName(Component.nullToEmpty(newControlName));
        this.entityData.set(CONTROL_NAME,newControlName);
    }

    public String getControlName() {
        return this.entityData.get(CONTROL_NAME);
    }


    public void setDest(BlockPos pos, boolean checks) {
        TARDIS tardis = TARDISManager.getInstance().findTARDIS(this.tardisID);
        tardis.getTravel().setDestination(new AbsoluteBlockPos(tardis.getTravel().getDestination().getDimension(), pos), checks);
    }

    public void setDest() {
        BlockPos targetPosition = new BlockPos(this.x, this.y, this.z);
        this.setListedPosition(this.tardisID, targetPosition);
        this.setDest(targetPosition, false);
    }

    public void setListedPosition(UUID tardisID, BlockPos bPos) {
        TARDIS tardis = TARDISManager.getInstance().findTARDIS(tardisID);
        x = bPos.getX(); // These variables get immediately reassigned lol, but just have it there in case we need to go back to it.
        y = bPos.getY();
        z = bPos.getZ();

        this.x = tardis.getTravel().getDestination().getX(); // This makes sure all controls have the same coords
        this.y = tardis.getTravel().getDestination().getY();
        this.z = tardis.getTravel().getDestination().getZ();
    }
    protected void updateCoordinates() {
        TARDIS tardis = TARDISManager.getInstance().findTARDIS(this.tardisID);
        this.x = tardis.getTravel().getDestination().getX(); // This makes sure all controls have the same coords
        this.y = tardis.getTravel().getDestination().getY();
        this.z = tardis.getTravel().getDestination().getZ();
    }

    public int getNextIncrement() {
        if(this.incrementValue < 10000) {
            this.incrementValue = this.incrementValue * 10;
        } else {
            this.incrementValue = 1;
        }
        return this.incrementValue;
    }

    public int getIncrementValue() {
        return this.incrementValue;
    }

    public void removeMe() {
        this.remove(RemovalReason.DISCARDED);
    }

    public void setHasBeenHit() {
        this.hasBeenHit = true;
    }

    public void setHasBeenHitOppo() {
        this.hasBeenHit = false;
    }

    public void setControlTag(String newControlTag, UUID tardisID) {
        this.addTag(newControlTag);
        this.tardisID = tardisID;
    }

    public static float xSize() {
        return ControlEntitySchema.sizing;
    }

    public static float ySize() {
        return ControlEntitySchema.sizing;
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_FLAGS, (byte)0);
        this.entityData.define(CONTROL_NAME,"");
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume() {
        return 0F;
    }

    /**
     * Gets the pitch of living sounds in living entities.
     */
    public float getVoicePitch() {
        return 0;
    }

    @Nullable
    public SoundEvent getAmbientSound() {
        return null;
    }

    @Nullable
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return null;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.BAT_DEATH;
    }

    /**
     * Returns true if this entity should push and be pushed by other entities when colliding.
     */
    public boolean isPushable() {
        return false;
    }

    protected void doPush(Entity pEntity) {
    }

    protected void pushEntities() {
    }

    public static AttributeSupplier setAttributes() {
        return ControlEntitySchema.createMobAttributes().add(Attributes.MAX_HEALTH, 6.0D).build();
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void tick() {
        /*if(this.getCustomName().getContents().equals("Dimension Switch") && this.tardisID != null) {
            if (this.tardisID != null) {

            }
        }*/
        /*if(this.getCustomName().getContents().equals("Exterior Facing") && this.tardisID != null) {
            if (this.tardisID != null) {
                Tardis tardis = AIT.tardisManager.getTardis(tardisID);
                if (tardis.landed != false) {
                    newFacingDirection = tardis.exterior_facing;
                    //currentExteriorFacingSetting = exteriorFacingSetting();
                }
            }
        }*/
        super.tick();
        this.setDeltaMovement(Vec3.ZERO);
        this.setPosRaw(this.getX(), this.getY(), this.getZ());
        this.setNoAi(true);
        //System.out.println(this.hasBeenHit);
    }

    @Override
    protected InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        ItemStack item = pPlayer.getMainHandItem();
        /*if(pHand == InteractionHand.MAIN_HAND) {
            this.remove(RemovalReason.DISCARDED);
        }*/
        //doInteractionStuff(pPlayer);
        this.remove(RemovalReason.DISCARDED); // why?
        return super.mobInteract(pPlayer, pHand);
    }

    protected void customServerAiStep() {
        super.customServerAiStep();
        BlockPos blockpos = this.blockPosition();
        BlockPos blockpos1 = blockpos.above();
        boolean flag = this.isSilent();
    }

    protected boolean isMovementNoisy() {
        return false;
    }

    public boolean causeFallDamage(float pFallDistance, float pDamageMultiplier) {
        return false;
    }

    protected void checkFallDamage(double pY, boolean pOnGround, BlockState pState, BlockPos pPos) {
    }

    /**
     * Return whether this entity should NOT trigger a pressure plate or a tripwire.
     */
    public boolean isIgnoringBlockTriggers() {
        return true;
    }

    public boolean pulled() {
        return this.isPulled;
    }

    public void setPulled(boolean bool, boolean updateClient) {
        this.isPulled = bool;

        if (updateClient) {
            Network.sendToAll(new UpdateLeverPulledS2CPacket(this.consolePosition, bool));
        }
    }

    /**
     * Called when the entity is attacked.
     * @param pSource
     */
    public void runInteractions(Player pSource) {
        if (pSource.level.isClientSide) return;

        /*boolean randomBool = false;
        if(!this.hasBeenHit && !randomBool) {
            this.setHasBeenHit();
            randomBool = true;
        }
        if(randomBool) {
            this.setHasBeenHitOppo();
            randomBool = false;
        }
        BlockPos blockPos = new BlockPos(this.getX(), this.getY(), this.getZ());*/
        //Tardis tardis = AIT.tardisManager.getTardis(tardisID);
        //ServerWorld world = AIT.server.getLevel(tardis.exterior_dimension);
        //ServerWorld tardisWorld = AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION);
        //assert world != null;
        //assert tardisWorld != null;
        /*if(this.getName() == ITextComponent.nullToEmpty("Throttle") && this.tardisID != null) {
            if (AIT.tardisManager.doesTardisHaveATargetLocation(this.tardisID)) {
                tardisWorld.playSound(null, tardis.center_position, AITSounds.TARDIS_TAKEOFF.get(), SoundCategory.MASTER, 7, 1);
                this.dematTransit = AIT.tardisManager.moveTardisToTargetLocation(tardisID);
                if(this.dematTransit.leverControl != this) {
                    this.dematTransit.leverControl = this;
                }
            }
        }*/
        //System.out.println(this.tardisID + " || " + this.getCustomName().getContents());
        /*Entity entity = pSource.getEntity();
        if(this.getCustomName().getContents().equals("Dimension Switch") && this.tardisID != null) {
            this.currentdimensionstate = getNextDimensionState();
            this.playSound(AITSounds.BUTTON_PRESS.get(), 5, 1);
            if(entity instanceof PlayerEntity) {
                ((PlayerEntity) entity).displayClientMessage(new TranslationTextComponent(
                        currentdimensionstate.name()).setStyle(Style.EMPTY.withColor(TextFormatting.WHITE).withBold(true)), true);;
            }
            changeDimensionFromControl();
        }
        if(this.getCustomName().getContents().equals("Exterior Facing") && this.tardisID != null) {
            this.currentExteriorFacingSetting = getNextExteriorFacingSetting();
            this.playSound(AITSounds.BUTTON_PRESS.get(), 5, 1);
            if(entity instanceof PlayerEntity) {
                ((PlayerEntity) entity).displayClientMessage(new TranslationTextComponent(
                        currentExteriorFacingSetting.name()).setStyle(Style.EMPTY.withColor(TextFormatting.WHITE).withBold(true)), true);;
            }
            changeDirectionFromControl();
        }
        if(this.getCustomName().getContents().equals("Monitor") && this.tardisID != null) {
            Minecraft.getInstance().setScreen(new MonitorScreen(new TranslationTextComponent("TARDIS Monitor"), this.tardisID, pSource.getCommandSenderWorld()));
        }
        if(!this.hurtMarked) {
            this.hurtMarked = true;
        } else {
            this.hurtMarked = false;
        }*/
    }

    public boolean hurt(DamageSource pSource, float pAmount) {
        Entity entity = pSource.getEntity();
        Player player = (Player) entity;
        if(player != null) {
            if (this.isInvulnerableTo(pSource)) {
                return false;
            } else {
                this.runInteractions(player);
            }
        }
        return super.hurt(pSource, 0);
    }

    protected float getStandingEyeHeight(Pose pPose, EntityDimensions pSize) {
        return pSize.height / 2.0F;
    }
}
