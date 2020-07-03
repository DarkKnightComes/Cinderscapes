package com.terraformersmc.cinderscapesold;

import com.terraformersmc.cinderscapesold.command.ShapeCommand;
import com.terraformersmc.cinderscapesold.init.*;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * [REVIEWED]
 *
 * @author <Wtoll> Will Toll on 2020-05-02
 * @project Cinderscapes
 */
public class Cinderscapes implements ModInitializer {

    public static final String MOD_ID = "cinderscapesold";
    public static final Logger LOGGER = LogManager.getLogger(StringUtils.capitalize(MOD_ID));

    /**
     * Initializes the custom content in the mod
     */
    @Override
    public void onInitialize() {
        CinderscapesItems.init();
        CinderscapesBlocks.init();
        CinderscapesTags.init();
        CinderscapesDecorators.init();
        CinderscapesFeatures.init();
        CinderscapesSurfaces.init();
        CinderscapesBiomes.init();
        CinderscapesGroups.init();
    }

    /**
     * Creates an identifier value using the Cinderscapes namespace
     * @param s The string representing the path of the identifier within the Cinderscapes namespace
     * @return An identifier with namespace equal to the Cinderscapes mod id and path equal to s
     */
    public static Identifier id(String s) {
        return new Identifier(MOD_ID, s);
    }
}