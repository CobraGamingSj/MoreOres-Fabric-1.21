//package net.cobra.moreores.world;
//
//import net.cobra.moreores.MoreOres;
//import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
//import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
//import net.minecraft.util.Identifier;
//import net.minecraft.world.GameRules;
//
//public class ModGameRules {
//    private static final int DEFAULT_POLISHING_SPEED = 400;
//    private static final int MIN_POLISHING_SPEED = 5;
//    private static final int MAX_POLISHING_SPEED = 4000;
//
//    public static final GameRules.Key<GameRules.IntRule> POLISHING_MAX_SPEED =
//            register("polishingMaxSpeed", GameRules.Category.UPDATES, GameRuleFactory.createIntRule(DEFAULT_POLISHING_SPEED, MIN_POLISHING_SPEED, MAX_POLISHING_SPEED));
//
//    @SuppressWarnings("SameParameterValue")
//    private static <T extends GameRules.Rule<T>> GameRules.Key<T> register(String name, GameRules.Category category, GameRules.Type<T> test) {
//        return GameRuleRegistry.register(name, category, test);
//    }
//
//    public static void register() {
//        MoreOres.LOGGER.info("Adding GameRules for " + MoreOres.MOD_ID + " mod.");
//    }
//
//}
