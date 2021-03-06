package net.bells.eldencraft.gen;

import net.bells.eldencraft.block.EldenBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.Features;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.blockplacers.SimpleBlockPlacer;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.RandomSpreadFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.BendingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;

import java.io.ObjectInputFilter;

public class ModConfiguredFeatures {

    public static final ConfiguredFeature<?, ?> LIMGRAVE_OAK = register("limgrave_oak", Feature.TREE.configured(
            new TreeConfiguration.TreeConfigurationBuilder(
                    new SimpleStateProvider(Blocks.OAK_WOOD.defaultBlockState()),
                    new FancyTrunkPlacer(17, 1, 7),
                    new SimpleStateProvider(Blocks.DARK_OAK_LEAVES.defaultBlockState()),
                    new SimpleStateProvider(EldenBlocks.LIMGRAVE_OAK_SAPLING.get().defaultBlockState()),
                    new FancyFoliagePlacer(UniformInt.of(2,2), UniformInt.of(2,3), 4),
                    new TwoLayersFeatureSize(5, 1, 15)).build()));

    public static final ConfiguredFeature<?, ?> LIMGRAVE_BIRCH = register("limgrave_birch", Feature.TREE.configured(
            new TreeConfiguration.TreeConfigurationBuilder(
                    new SimpleStateProvider(Blocks.BIRCH_WOOD.defaultBlockState()),
                    new BendingTrunkPlacer(5, 1, 2,5,UniformInt.of(1,2)),
                    new SimpleStateProvider(Blocks.OAK_LEAVES.defaultBlockState()),
                    new SimpleStateProvider(EldenBlocks.LIMGRAVE_BIRCH_SAPLING.get().defaultBlockState()),
                    //new BlobFoliagePlacer(UniformInt.of(2,2), UniformInt.of(3,4), 5),
                    //new FancyFoliagePlacer(UniformInt.of(1,1), UniformInt.of(4,5), 7),
                    new RandomSpreadFoliagePlacer(UniformInt.of(2,3), UniformInt.of(2,2), UniformInt.of(3,4),32),

                    new TwoLayersFeatureSize(5, 1, 15)).build()));




    public static final ConfiguredFeature<?, ?> ELDEN_PATCH = Feature.FLOWER.configured((
            new RandomPatchConfiguration.GrassConfigurationBuilder(
                    new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(EldenBlocks.ELDEN_FLOWER.get().defaultBlockState(), 5).add(EldenBlocks.ELDEN_GRASS.get().defaultBlockState(), 10)), //maybe no build
                    SimpleBlockPlacer.INSTANCE)).tries(12).build())
            .decorated(Features.Decorators.HEIGHTMAP_WITH_TREE_THRESHOLD_SQUARED).count(5);


    private static <FC extends FeatureConfiguration>ConfiguredFeature<FC, ?> register(String name,
                                                                                      ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, name, configuredFeature);
    }
}
