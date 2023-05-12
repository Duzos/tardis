package com.duzo.tardis.core.screens;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.network.Network;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

import java.util.UUID;

public class MonitorScreen extends Screen {
    private static final ResourceLocation GUI_TEXTURE = new ResourceLocation(TARDISMod.MODID,"textures/gui/borealis_monitor.png");
    private Player player;
    private UUID tardisID;
    protected int imageWidth = 256;
    protected int imageHeight = 128;
    private Button confirm,exteriorChangeUp, exteriorChangeDown;

    public MonitorScreen(Component component, UUID tardisID, Player player) {
        super(component);
        this.tardisID = tardisID;
        this.player = player;

        if (this.minecraft == null) {
            this.minecraft = this.getMinecraft();
        }
    }

    @Override
    protected void init() {
        super.init();
        int l = (this.height - this.imageHeight) / 2;
        int i = (this.width - this.imageWidth) / 2;

        assert this.minecraft != null;

        this.exteriorChangeUp = new Button((i) + (this.imageWidth/2) + 93,l + 100,15,15, Component.translatable("screen.ait.ceu"), (p_96786_) -> {
            this.pressChangeExteriorButton(true);
        });
        this.addRenderableWidget(this.exteriorChangeUp);
        this.exteriorChangeDown = new Button((i) + (this.imageWidth/2) + 49, l + 100,15,15,Component.translatable("screen.ait.ceo"), (p_96786_) -> {
            this.pressChangeExteriorButton(false);
        });
        this.addRenderableWidget(this.exteriorChangeDown);
        this.confirm = new Button((i) + (this.imageWidth/2) + 62,l + 100,33,15,Component.translatable("screen.ait.done"), (p_96786_) -> {
            this.pressDoneButton();
        });
        this.addRenderableWidget(this.confirm);
    }

    private void pressDoneButton() {
        this.onClose();
    }

    private void pressChangeExteriorButton(boolean isUp) {
        if(isUp) {
            //Network.sendToServer(new SendHumanoidChatC2SPacket(this.humanoid.getUUID(), this.chatBox.getValue()));
        } else {
            //Network.sendToServer(new SendHumanoidChatC2SPacket(this.humanoid.getUUID(), this.chatBox.getValue()));
        }
    }

    @Override
    public void render(PoseStack pPoseStack, int mouseX, int mouseY, float delta) {
        this.renderBg(pPoseStack);
        int l = (this.height - this.imageHeight) / 2;
        int i = (this.width - this.imageWidth) / 2;
        pPoseStack.pushPose();
        this.font.draw(pPoseStack,"[Location: 0 0 0]",i + (this.imageWidth/2)  -    105, l + 30,16777215);
        this.font.draw(pPoseStack,"[Destination: 0 0 0]",i + (this.imageWidth/2) -  105, l + 45,16777215);
        this.font.draw(pPoseStack,"[Exterior: Basic Box]",i + (this.imageWidth/2) - 105, l + 60,16777215);
        this.font.draw(pPoseStack,"[Interior: Pristine]",i + (this.imageWidth/2)  - 105, l + 75,16777215);
        this.font.draw(pPoseStack,"[Console: Borealis]",i + (this.imageWidth/2)   - 105, l + 90,16777215);
        pPoseStack.popPose();
        super.render(pPoseStack, mouseX, mouseY, delta);
    }

    public void renderBg(PoseStack p_96557_) {
        RenderSystem.setShaderTexture(0, GUI_TEXTURE);
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        blit(p_96557_, i, j, 0, 0, this.imageWidth, this.imageHeight);
    }
}
