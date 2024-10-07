package net.moreores.item;

import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;

public class MusicDiscItem extends Item {
    public MusicDiscItem(Settings settings, RegistryKey<JukeboxSong> jukeboxSongRegistryKey) {
        super(settings.jukeboxPlayable(jukeboxSongRegistryKey));
    }
}
