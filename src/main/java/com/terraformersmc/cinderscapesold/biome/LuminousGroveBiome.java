package com.terraformersmc.cinderscapesold.biome;

import com.google.common.collect.ImmutableList;
import com.terraformersmc.cinderscapesold.decorator.config.CountSafelistRangeDecoratorConfig;
import com.terraformersmc.cinderscapesold.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapesold.init.CinderscapesDecorators;
import com.terraformersmc.cinderscapesold.init.CinderscapesFeatures;
import com.terraformersmc.cinderscapesold.init.CinderscapesSurfaces;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.sound.MusicType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BiomeAdditionsSound;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.BiomeParticleConfig;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.NoiseHeightmapDecoratorConfig;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

import java.util.Arrays;
import java.util.List;

public class LuminousGroveBiome extends Biome {
    public LuminousGroveBiome() {
        super((new Settings())
                .configureSurfaceBuilder(SurfaceBuilder.NETHER_FOREST, CinderscapesSurfaces.LUMINOUS_NYLIUM_CONFIG)
                .precipitation(Precipitation.NONE)
                .category(Category.NETHER)
                .depth(0.1F)
                .scale(0.2F)
                .temperature(2.0F)
                .downfall(0.0F)
                .effects((new BiomeEffects.Builder())
                        .waterColor(4159204)
                        .waterFogColor(329011)
                        .fogColor(2297392)
                        .particleConfig(new BiomeParticleConfig(ParticleTypes.WARPED_SPORE, 0.01428F))
                        .loopSound(SoundEvents.AMBIENT_WARPED_FOREST_LOOP)
                        .moodSound(new BiomeMoodSound(SoundEvents.AMBIENT_WARPED_FOREST_MOOD, 6000, 8, 2.0D))
                        .additionsSound(new BiomeAdditionsSound(SoundEvents.AMBIENT_WARPED_FOREST_ADDITIONS, 0.0111D))
                        .music(MusicType.method_27283(SoundEvents.MUSIC_NETHER_WARPED_FOREST))
                        .build())
                .parent(null)
                .noises(ImmutableList.of(new MixedNoisePoint(0.35F, 0.35F, 0.0F, 0.0F, 0.2F))));


        // UMBRAL FUNGUS
        List<BlockState> safelist = Arrays.asList(CinderscapesBlocks.UMBRAL_NYLIUM.getDefaultState(), Blocks.NETHERRACK.getDefaultState());
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesFeatures.CANOPIED_HUGE_FUNGUS.configure(CinderscapesFeatures.UMBRAL_FUNGUS_NOT_PLANTED_CONFIG).createDecoratedFeature(CinderscapesDecorators.COUNT_FLOOR.configure(new CountSafelistRangeDecoratorConfig(32, 20, 20, 128, safelist))));

        // GLOWSTONE
        this.addFeature(net.minecraft.world.gen.GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.GLOWSTONE_BLOB.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.LIGHT_GEM_CHANCE.configure(new CountDecoratorConfig(40))));
        this.addFeature(net.minecraft.world.gen.GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.GLOWSTONE_BLOB.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(40, 0, 0, 128))));

        // SHROOMLIGHT BUSHES
        this.addFeature(net.minecraft.world.gen.GenerationStep.Feature.UNDERGROUND_DECORATION, CinderscapesFeatures.SHROOMLIGHT_BUSH.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(5, 0, 0, 128))));

        // VEGETATION
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesFeatures.VEGETATION.configure(CinderscapesFeatures.LUMINOUS_GROVE_VEGETATION_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP.configure(new CountDecoratorConfig(8))));
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(CinderscapesFeatures.LUMINOUS_POD_CONFIG).createDecoratedFeature(Decorator.NOISE_HEIGHTMAP_32.configure(new NoiseHeightmapDecoratorConfig(-0.8D, 0, 7))));
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(CinderscapesFeatures.TALL_PHOTOFERN_CONFIG).createDecoratedFeature(Decorator.NOISE_HEIGHTMAP_32.configure(new NoiseHeightmapDecoratorConfig(-0.8D, 0, 7))));

        // VINES
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, CinderscapesFeatures.UMBRAL_VINE.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(20, 0, 0, 128))));

        // DEFAULT MINECRAFT FEATURES
        this.addStructureFeature(DefaultBiomeFeatures.FORTRESS);
        this.addStructureFeature(DefaultBiomeFeatures.BASTION_REMNANT);
        this.addStructureFeature(DefaultBiomeFeatures.NETHER_RUINED_PORTAL);
        this.addCarver(GenerationStep.Carver.AIR, configureCarver(net.minecraft.world.gen.carver.Carver.NETHER_CAVE, new ProbabilityConfig(0.2F)));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, net.minecraft.world.gen.feature.Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NETHERRACK, Blocks.MAGMA_BLOCK.getDefaultState(), 33)).createDecoratedFeature(Decorator.MAGMA.configure(new CountDecoratorConfig(4))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, net.minecraft.world.gen.feature.Feature.SPRING_FEATURE.configure(DefaultBiomeFeatures.ENCLOSED_NETHER_SPRING_CONFIG).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(16, 10, 20, 128))));
        DefaultBiomeFeatures.addNetherMineables(this);

        // SPAWNS
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.ENDERMAN, 1, 4, 4));
        this.addSpawn(SpawnGroup.CREATURE, new SpawnEntry(EntityType.STRIDER, 60, 1, 2));
        this.addSpawnDensity(EntityType.ENDERMAN, 1.0D, 0.12D);


    }
}
