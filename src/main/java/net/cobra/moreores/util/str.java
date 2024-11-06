//package net.cobra.moreores.util;
//
//
//import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
//import net.minecraft.block.Block;
//import net.minecraft.item.BlockItem;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemStack;
//import net.minecraft.item.Items;
//import net.minecraft.village.TradeOffer;
//import net.minecraft.village.TradedItem;
//import net.minecraft.village.VillagerProfession;
//
//public class str {
//    public static void add() {
//        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 1, factories -> {
//            factories.add((entity, random) -> {
//                Block randomFlower = flowers.get(random.nextInt(flowers.size()));
//
//                return new TradeOffer(
//                        new TradedItem(new BlockItem(randomFlower, new Item.Settings()), 5),
//                        new ItemStack(Items.EMERALD, 1),
//                        12,
//                        1,
//                        0.05f
//                );
//            });
//            factories.add((entity, random) -> {
//                Block randomTallFlower = tallFlowers.get(random.nextInt(tallFlowers.size()));
//
//                return new TradeOffer(
//                        new TradedItem(new BlockItem(randomTallFlower, new Item.Settings()), 3),
//                        new ItemStack(Items.EMERALD, 1),
//                        12,
//                        1,
//                        0.05f
//                );
//            });
//        });
//    }
//}
