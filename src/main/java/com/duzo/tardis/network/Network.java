package com.duzo.tardis.network;

import com.duzo.tardis.TARDISMod;
import com.duzo.tardis.network.packets.UpdateExteriorAnimationS2CPacket;
import com.duzo.tardis.network.packets.UpdateExteriorDoorS2CPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class Network {
    private static SimpleChannel INSTANCE;

    private static int packetId = 0;
    private static int id() {
        return packetId++;
    }

    public static void register() {
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(TARDISMod.MODID, "messages"))
                .networkProtocolVersion(() -> "1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

        INSTANCE = net;

        net.messageBuilder(UpdateExteriorAnimationS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(UpdateExteriorAnimationS2CPacket::decode)
                .encoder(UpdateExteriorAnimationS2CPacket::encode)
                .consumerMainThread(UpdateExteriorAnimationS2CPacket::handle)
                .add();
        net.messageBuilder(UpdateExteriorDoorS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(UpdateExteriorDoorS2CPacket::decode)
                .encoder(UpdateExteriorDoorS2CPacket::encode)
                .consumerMainThread(UpdateExteriorDoorS2CPacket::handle)
                .add();
    }

    public static <MSG> void sendToServer(MSG message) {
        INSTANCE.sendToServer(message);
    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }

    public static <MSG> void sendToAll(MSG message) {
        INSTANCE.send(PacketDistributor.ALL.noArg(), message);
    }
}