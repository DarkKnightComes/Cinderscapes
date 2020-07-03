package com.terraformersmc.cinderscapesold.decorator.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.Direction;
import net.minecraft.world.gen.decorator.DecoratorConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <Wtoll> Will Toll on 2020-06-16
 * @project Cinderscapes
 */
public class UberCountDecoratorConfig implements DecoratorConfig {
    public final int count;
    public final int bottomOffset;
    public final int topOffset;
    public final int maximum;

    public final List<BlockState> placeableList;
    public final List<BlockState> replaceableList;

    public final Direction offset;
    public final int radius;

    public UberCountDecoratorConfig(int count, int bottomOffset, int topOffset, int maximum, List<BlockState> placeableList, List<BlockState> replaceableList, Direction offset, int radius) {
        this.count = count;
        this.bottomOffset = bottomOffset;
        this.topOffset = topOffset;
        this.maximum = maximum;
        this.placeableList = placeableList;
        this.replaceableList = replaceableList;
        this.offset = offset;
        this.radius = radius;
    }

    public UberCountDecoratorConfig(int count, int bottomOffset, int topOffset, int maximum, List<BlockState> placeableList, List<BlockState> replaceableList, String offset, int radius) {
        this(count, bottomOffset, topOffset, maximum, placeableList, replaceableList, Direction.byName(offset), radius);
    }

    public static final Codec<UberCountDecoratorConfig> CODEC = RecordCodecBuilder.create((instance) -> {
        return instance.group(Codec.INT.fieldOf("count").forGetter((config) -> {
            return config.count;
        }), Codec.INT.fieldOf("bottom_offset").withDefault(0).forGetter((config) -> {
            return config.bottomOffset;
        }), Codec.INT.fieldOf("top_offset").withDefault(0).forGetter((config) -> {
            return config.topOffset;
        }), Codec.INT.fieldOf("maximum").withDefault(255).forGetter((config) -> {
            return config.maximum;
        }), BlockState.CODEC.listOf().fieldOf("placeable_list").withDefault(new ArrayList<>()).forGetter((config) -> {
            return config.placeableList;
        }), BlockState.CODEC.listOf().fieldOf("replaceable_list").withDefault(new ArrayList<>()).forGetter((config) -> {
            return config.replaceableList;
        }), Codec.STRING.fieldOf("offset").forGetter((config) -> {
            return config.offset.getName();
        }), Codec.INT.fieldOf("radius").withDefault(0).forGetter((config) -> {
            return config.radius;
        })).apply(instance, UberCountDecoratorConfig::new);
    });
}
