//package net.moreores.networking;
//
//import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
//import net.minecraft.util.Identifier;
//import net.moreores.MoreOres;
//
//public class ModMessages {
//
//    public static final Identifier ENERGY_SYNC = Identifier.of(MoreOres.MOD_ID, "energy_sync");
//
//    public static void registerS2CPackets() {
//        ClientPlayNetworking.registerGlobalReceiver(ENERGY_SYNC, (client, handler, buf, responseSender) -> {
//            EnergySyncS2CPacket.receive(client, handler, buf, responseSender);
//        });
//    }
//
//}
