package vitu.modao.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import vitu.modao.Modaomod;

public class ModItemGroups {

    //GERAÇÃO DE GRUPO DE ITENS

    //GRUPO DE COMIDAS
    public static final ItemGroup FOOD_MODAO_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Modaomod.MOD_ID,  "food_modao_group"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.PAMONHA))
                    .displayName(Text.translatable("itemgroup.modaomod.food_modao_group"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.SEMENTE_DE_MILHO);
                        entries.add(ModItems.MILHO);
                        entries.add(ModItems.PAMONHA);
                    }).build());

    //GRUPO DE MATERIAIS
    public static final ItemGroup MATERIAL_MODAO_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Modaomod.MOD_ID,  "material_modao_group"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.ALMA))
                    .displayName(Text.translatable("itemgroup.modaomod.material_modao_group"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.ALMA);
                    }).build());



    //GRUPO DE ARMAS E EQUIPAMENTOS
    public static final ItemGroup WEAPON_MODAO_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Modaomod.MOD_ID,  "weapon_modao_group"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.SOUL_SWORD))
                    .displayName(Text.translatable("itemgroup.modaomod.weapon_modao_group"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.SOUL_SWORD);
                        entries.add(ModItems.VIOLE_SWORD);
                    }).build());

    public static void registerItemGroups(){
        Modaomod.LOGGER.info("Registrando grupos do " + Modaomod.MOD_ID);
    }

}
