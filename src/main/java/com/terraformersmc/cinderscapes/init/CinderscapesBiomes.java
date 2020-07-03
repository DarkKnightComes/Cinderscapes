package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.fabricmc.fabric.api.biomes.v1.NetherBiomes;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

import java.util.HashMap;
import java.util.Map;

/**
 * The main initializer class for Cinderscapes' biomes
 *
 * @see CinderscapesBiomes#onInitialize()
 */
public class CinderscapesBiomes {

    /**
     * A private map that acts as an internal registry for all of Cinderscapes' biomes.
     */
    private static final Map<Identifier, Biome> BIOMES = new HashMap<>();

    public static final Biome BLACKSTONE_SHALES = add("blackstone_shales", new BlackstoneShalesBiome());

    /**
     * Initializes all of the Cinderscapes' biomes.
     *
     * All biomes added to the local registry are reasonably assumed to be nether biomes
     *
     * @see Cinderscapes#onInitialize()
     */
    public static void onInitialize() {
        BIOMES.forEach((id, biome) -> {
            Registry.register(Registry.BIOME, id, biome);
            NetherBiomes.addNetherBiome(biome);
        });
    }

    /**
     * Adds the given biome to the local registry.
     *
     * The biome is registered under the Cinderscapes namespace.
     * @param s The path of the identifier the biome is added to the registry under.
     * @param biome The biome that is added to the registry.
     * @param <B> The specific type of the biome that is given, must extend net.minecraft.world.biome.Biome.
     * @return Returns the biome that was added to the local registry.
     */
    private static <B extends Biome> B add(String s, B biome) {
        BIOMES.put(Cinderscapes.id(s), biome);
        return biome;
    }
}
