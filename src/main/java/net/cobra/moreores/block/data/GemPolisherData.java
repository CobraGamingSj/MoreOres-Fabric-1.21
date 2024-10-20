package net.cobra.moreores.block.data;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.util.math.BlockPos;

public record GemPolisherData(BlockPos blockPos) {

    public static final PacketCodec<RegistryByteBuf, GemPolisherData> PACKET_CODEC =
            PacketCodec.tuple(BlockPos.PACKET_CODEC, GemPolisherData::blockPos, GemPolisherData::new);
}
