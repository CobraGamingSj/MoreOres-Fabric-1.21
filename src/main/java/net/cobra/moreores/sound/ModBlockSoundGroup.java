package net.cobra.moreores.sound;

import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.cobra.moreores.MoreOres;

public class ModBlockSoundGroup {

    public static final BlockSoundGroup ENERGY_BLOCK = new BlockSoundGroup(5f, 1f, SoundEvents.BLOCK_HEAVY_CORE_STEP, SoundEvents.BLOCK_HEAVY_CORE_BREAK, SoundEvents.BLOCK_HEAVY_CORE_PLACE, SoundEvents.BLOCK_HEAVY_CORE_HIT, SoundEvents.BLOCK_HEAVY_CORE_FALL);

    public static void register() {
        MoreOres.LOGGER.info("Loading ModBlockSoundGroups for " + MoreOres.MOD_ID + " mod.");
    }

}
