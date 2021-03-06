package net.bells.eldencraft.structure;
import net.bells.eldencraft.EldenCraft;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
public class EldenConfiguredStructures {
    /**
     * Static instance of our structure so we can reference it and add it to biomes easily.
     */
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_DIVINE_TOWER = EldenStructures.DIVINE_TOWER.get().configured(NoneFeatureConfiguration.INSTANCE);
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_LARGE_RUINS = EldenStructures.LARGE_RUINS.get().configured(NoneFeatureConfiguration.INSTANCE);
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_MINOR_ERDTREE = EldenStructures.MINOR_ERDTREE.get().configured(NoneFeatureConfiguration.INSTANCE);
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_LIKBIL = EldenStructures.LIKBIL.get().configured(NoneFeatureConfiguration.INSTANCE);

    public static ConfiguredStructureFeature<?, ?> CONFIGURED_SMALL_ARCH= EldenStructures.SMALL_ARCH.get().configured(NoneFeatureConfiguration.INSTANCE);
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_LARGE_ARCH= EldenStructures.LARGE_ARCH.get().configured(NoneFeatureConfiguration.INSTANCE);
    /**
     * Registers the configured structure which is what gets added to the biomes.
     * Noticed we are not using a forge registry because there is none for configured structures.
     *
     * We can register configured structures at any time before a world is clicked on and made.
     * But the best time to register configured features by code is honestly to do it in FMLCommonSetupEvent.
     */
    public static void registerConfiguredStructures() {
        Registry<ConfiguredStructureFeature<?, ?>> registry = BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE;

        Registry.register(registry, new ResourceLocation(EldenCraft.MOD_ID, "configured_divine_tower"), CONFIGURED_DIVINE_TOWER);
        Registry.register(registry, new ResourceLocation(EldenCraft.MOD_ID, "configured_large_ruins"), CONFIGURED_LARGE_RUINS);
        Registry.register(registry, new ResourceLocation(EldenCraft.MOD_ID, "configured_minor_erdtree"), CONFIGURED_MINOR_ERDTREE);
        Registry.register(registry, new ResourceLocation(EldenCraft.MOD_ID, "configured_likbil"), CONFIGURED_LIKBIL);
        Registry.register(registry, new ResourceLocation(EldenCraft.MOD_ID, "configured_large_arch"), CONFIGURED_LARGE_ARCH);

        Registry.register(registry, new ResourceLocation(EldenCraft.MOD_ID, "configured_small_arch"), CONFIGURED_SMALL_ARCH);
    }

}
