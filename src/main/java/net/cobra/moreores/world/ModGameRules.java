package net.cobra.moreores.world;

import net.cobra.moreores.MoreOres;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

public class ModGameRules {
    private static final int DEFAULT_POLISHING_SPEED = 400;
    private static final int MIN_POLISHING_SPEED = 5;
    private static final int MAX_POLISHING_SPEED = 4000;

    public static final GameRules.Key<GameRules.IntRule> POLISHING_MAX_SPEED =
            GameRuleRegistry.register("polishingMaxSpeed", GameRules.Category.UPDATES, GameRuleFactory.createIntRule(DEFAULT_POLISHING_SPEED, MIN_POLISHING_SPEED, MAX_POLISHING_SPEED));

    public static int getMaxPolishingSpeed(World world) {
        if (world instanceof ServerWorld) {
            ((ServerWorld) world).getGameRules().getInt(POLISHING_MAX_SPEED);
        }
        return DEFAULT_POLISHING_SPEED;
    }

    public static void register() {
        MoreOres.LOGGER.info("Adding Gamerules for " + MoreOres.MOD_ID + " mod.");
    }

}
