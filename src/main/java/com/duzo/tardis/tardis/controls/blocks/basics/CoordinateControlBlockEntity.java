package com.duzo.tardis.tardis.controls.blocks.basics;

import com.duzo.tardis.core.util.AbsoluteBlockPos;
import com.duzo.tardis.tardis.controls.CoordinateControlSchema;
import com.duzo.tardis.tardis.controls.TARDISControlSchema;
import com.duzo.tardis.tardis.controls.blocks.ControlBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;

import java.util.List;

public abstract class CoordinateControlBlockEntity extends ControlBlockEntity {
    private BlockPos pos;
    public CoordinateControlBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public abstract CoordinateControlSchema<?> getSchema();

    @Override
    protected void run(Player player, BlockHitResult hit) {
        if (this.pos == null) {
            this.pos = this.getTARDIS().getPosition();
        }

        Direction direction = this.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING);

        List<Double> XPositions = this.getSchema().getXButtonPositions(direction);
        List<Double> YPositions = this.getSchema().getYButtonPositions(direction);
        List<Double> ZPositions = this.getSchema().getZButtonPositions(direction);

        double mouseX = hit.getLocation().x - this.getBlockPos().getX();
        double mouseZ = hit.getLocation().z - this.getBlockPos().getZ();
        boolean isHoveredOverX = mouseX >= XPositions.get(0) && mouseZ >= XPositions.get(2) && mouseX <= (XPositions.get(0) + XPositions.get(3)) && mouseZ <= (XPositions.get(2) + XPositions.get(4));
        boolean isHoveredOverY = mouseX >= YPositions.get(0) && mouseZ >= YPositions.get(2) && mouseX <= (YPositions.get(0) + YPositions.get(3)) && mouseZ <= (YPositions.get(2) + YPositions.get(4));
        boolean isHoveredOverZ = mouseX >= ZPositions.get(0) && mouseZ >= ZPositions.get(2) && mouseX <= (ZPositions.get(0) + ZPositions.get(3)) && mouseZ <= (ZPositions.get(2) + ZPositions.get(4));

        System.out.println(mouseX);
        System.out.println(mouseZ);
        System.out.println(XPositions.get(0));
        System.out.println(XPositions.get(2));

        if (isHoveredOverX) {
            this.pos = this.pos.offset(1,0,0);
        }
        else if (isHoveredOverY) {
            this.pos = this.pos.offset(0, 1, 0);
        }
        else if (isHoveredOverZ) {
            this.pos = this.pos.offset(0,0,1);
        }

        System.out.println(this.pos);
        this.getTARDIS().getTravel().setDestination(new AbsoluteBlockPos(this.getTARDIS().getTravel().getDestination().getDimension(),this.pos),true);
    }
}
