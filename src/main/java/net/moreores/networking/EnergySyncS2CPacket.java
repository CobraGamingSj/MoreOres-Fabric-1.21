//package net.moreores.networking;
//
//import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
//import net.fabricmc.fabric.api.networking.v1.PacketSender;
//import net.minecraft.client.MinecraftClient;
//import net.minecraft.client.network.ClientPlayNetworkHandler;
//import net.minecraft.network.PacketByteBuf;
//import net.minecraft.network.packet.CustomPayload;
//import net.minecraft.util.math.BlockPos;
//import net.moreores.block.entity.GemPolisherBlockEntity;
//import net.moreores.screen.GemPolisherScreenHandler;
//
//public class EnergySyncS2CPacket {
//    public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler, PacketByteBuf buf, PacketSender sender) {
//        long energy = buf.readLong();
//        BlockPos pos = buf.readBlockPos();
//
//        if (client.world.getBlockEntity(pos) instanceof GemPolisherBlockEntity blockEntity) {
//            blockEntity.setEnergyLevel(energy);
//
//            if (client.player.currentScreenHandler instanceof GemPolisherScreenHandler screenHandler && screenHandler.blockEntity.getPos().equals(pos)) {
//                blockEntity.setEnergyLevel(energy);
//            }
//        }
//    }
//
//    p
//}
