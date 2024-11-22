//package net.cobra.moreores.block.data;
//
//import net.minecraft.network.RegistryByteBuf;
//import net.minecraft.network.codec.PacketCodec;
//import net.minecraft.util.math.BlockPos;
//
//public record GemstoneStorageData(BlockPos blockPos) {
//    public static final PacketCodec<RegistryByteBuf, GemstoneStorageData> PACKET_CODEC = PacketCodec.tuple(BlockPos.PACKET_CODEC, GemstoneStorageData::blockPos, GemstoneStorageData::new);
//}
