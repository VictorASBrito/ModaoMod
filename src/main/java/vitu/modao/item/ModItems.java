package vitu.modao.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import vitu.modao.Modaomod;
import vitu.modao.item.custom.LiburSwordItem;
import vitu.modao.item.custom.TaeWonLance;
import vitu.modao.item.custom.VioleSwordItem;

public class ModItems {

    //CLASSE PARA GERAÇÃO DE ITENS


    //COMIDA
    public static final Item PAMONHA = registerItem("pamonha", new Item(new Item.Settings().food(ModFoodComponents.PAMONHA)));
    public static final Item MILHO  = registerItem("milho", new Item(new Item.Settings().food(ModFoodComponents.MILHO)));
    public static final Item SEMENTE_DE_MILHO = registerItem("semente_de_milho", new Item(new Item.Settings()));


    //MATERIAIS
    public static final Item ALMA = registerItem("alma", new Item(new Item.Settings()));


    //EQUIPAMENTOS
    public static final Item SOUL_SWORD = registerItem("soul_sword",
            new SwordItem(ModToolMaterial.ALMA, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterial.ALMA, 3, -2.4f))));
    public static final Item VIOLE_SWORD = registerItem("viole_sword",
            new VioleSwordItem(new Item.Settings().attributeModifiers(VioleSwordItem.createAttributeModifiers()).maxDamage(1500).rarity(Rarity.EPIC)));
    public static final Item LIBUR_SWORD = registerItem("libur_sword",
            new LiburSwordItem(new Item.Settings().attributeModifiers(LiburSwordItem.createAttributeModifiers()).maxDamage(0).rarity(Rarity.EPIC)));
    public static final Item TAEWON_ABILITY = registerItem("taewon_ability", new Item(new Item.Settings()));
    public static final Item TAEWON_LANCE   = registerItem("taewon_lance",
            new TaeWonLance(new Item.Settings()
                    .attributeModifiers(TaeWonLance.createAttributeModifiers())
                    .maxDamage(0)
                    .rarity(Rarity.EPIC)
                    .component(DataComponentTypes.TOOL, TaeWonLance.createToolComponent())));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(Modaomod.MOD_ID, name), item);
    }


}
