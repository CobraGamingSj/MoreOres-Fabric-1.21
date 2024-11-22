package net.cobra.moreores.block.data;

import net.cobra.moreores.MoreOresModInitializer;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public record GemPolisherData(BlockPos blockPos) implements CustomPayload {
        private static final Id<GemPolisherData> ID = new Id<>(Identifier.of(MoreOresModInitializer.MOD_ID, "pos"));

    public static final PacketCodec<RegistryByteBuf, GemPolisherData> PACKET_CODEC =
            PacketCodec.tuple(BlockPos.PACKET_CODEC, GemPolisherData::blockPos, GemPolisherData::new);

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
