package com.terraformersmc.cinderscapes;

import com.terraformersmc.cinderscapes.init.CinderscapesBiomes;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

/**
 * This is the root class of the mod that is loaded by fabric at run time.
 * @see Cinderscapes#onInitialize()
 */
@SuppressWarnings("unused")
public class Cinderscapes implements ModInitializer {

    /**
     * A static string representing the namespace of all content in the mod
     */
    public static final String MODID = "cinderscapes";

    /**
     * The main initialization method used as an entry point for fabric.
     */
    @Override
    public void onInitialize() {
        CinderscapesBlocks.onInitialize();
        CinderscapesBiomes.onInitialize();
    }

    /**
     * Creates an identifier within the mod's namespace.
     * @param s The path for the identifier.
     * @return An identifier with the mod's namespace and the given path.
     * @see Cinderscapes#MODID
     */
    public static Identifier id(String s) {
        return new Identifier(MODID, s);
    }
}
