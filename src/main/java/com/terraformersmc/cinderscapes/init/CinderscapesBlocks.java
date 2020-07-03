package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;

/**
 * The main initializer class for Cinderscapes' blocks
 *
 * @see CinderscapesBlocks#onInitialize()
 */
public class CinderscapesBlocks {

    /**
     * A private map that acts as an internal registry for all of Cinderscapes' blocks.
     */
    private static final Map<Identifier, Block> BLOCKS = new HashMap<>();

    /**
     * A private map that acts as an internal registry for all of Cinderscapes' block items.
     */
    private static final Map<Identifier, BlockItem> BLOCK_ITEMS = new HashMap<>();







    /**
     * Initializes all of the Cinderscapes' blocks.
     *
     * @see Cinderscapes#onInitialize()
     */
    public static void onInitialize() {
        BLOCKS.forEach((id, block) -> Registry.register(Registry.BLOCK, id, block));
        BLOCK_ITEMS.forEach((id, blockItem) -> Registry.register(Registry.ITEM, id, blockItem));
    }

    /**
     * Adds the given block to the local registry.
     *
     * The block is registered under the Cinderscapes namespace.
     * @param s The path of the identifier the block is added to the registry under.
     * @param block The block that is added to the registry.
     * @param <B> The specific type of the block that is given, must extend net.minecraft.block.Block.
     * @return Returns the block that was added to the local registry.
     */
    private static <B extends Block> B add(String s, B block) {
        BLOCKS.put(Cinderscapes.id(s), block);
        return block;
    }

    /**
     * Adds the given block and its block item to the local registry.
     *
     * The block and item are registered under the Cinderscapes namespace.
     *
     * If the block item is not constructed with the given block then it is not registered
     * @param s The path of the identifier the block is added to the registry under.
     * @param block The block that is added to the registry.
     * @param item The block item that is added to the registry.
     * @param <B> The specific type of the block that is given, must extend net.minecraft.block.Block.
     * @param <I> The specific type of the block item that is given, must extend net.minecraft.item.BlockItem
     * @return Returns the block that was added to the local registry
     */
    private static <B extends Block, I extends BlockItem> B add(String s, B block, I item) {
        if (item.getBlock().equals(block)) {
            item.appendBlocks(Item.BLOCK_ITEMS, item);
            BLOCK_ITEMS.put(Cinderscapes.id(s), item);
        }
        return add(s, block);
    }

    /**
     * Adds the given block to the local registry, and constructs a corresponding block item with the given settings.
     *
     * The block and item are registered under the Cinderscapes namespace.
     * @param s The path of the identifier the block is added to the registry under.
     * @param block The block that is added to the registry.
     * @param itemSettings The settings of the block item to be constructed.
     * @param <B> The specific type of the block that is given, must extend net.minecraft.block.Block.
     * @return Returns the block that was added to the local registry
     */
    private static <B extends Block> B add(String s, B block, Item.Settings itemSettings) {
        return add(s, block, new BlockItem(block, itemSettings));
    }

    /**
     * Adds the given block to the local registry and constructs a corresponding block item with the given group.
     *
     * The block and item are registered under the Cinderscapes namespace.
     * @param s The path of the identifier the block is added to the registry under.
     * @param block The block that is added to the registry.
     * @param group The item group the block item should be added to.
     * @param <B> The specific type of the block that is given, must extend net.minecraft.block.Block.
     * @return Returns the block that was added to the local registry.
     */
    private static <B extends Block> B add(String s, B block, ItemGroup group) {
        return add(s, block, new Item.Settings().group(group));
    }
}
