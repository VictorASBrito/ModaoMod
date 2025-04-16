package vitu.modao.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import vitu.modao.Modaomod;

public class ModItems {

    //CLASSE PARA GERAÇÃO DE ITENS


    //COMIDA
    public static final Item PAMONHA = registerItem("pamonha", new Item(new Item.Settings().food(ModFoodComponents.PAMONHA)));
    public static final Item MILHO  = registerItem("milho", new Item(new Item.Settings().food(ModFoodComponents.MILHO)));
    public static final Item SEMENTE_DE_MILHO = registerItem("semente_de_milho", new Item(new Item.Settings()));


    //MATERIAIS
    public static final Item ALMA = registerItem("alma", new Item(new Item.Settings()));


    //EQUIPAMENTOS
    public static final Item VIOLE_SWORD = registerItem("viole_sword",
            new SwordItem(ModToolMaterial.ALMA, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterial.ALMA, 3, -2.4f))));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(Modaomod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        Modaomod.LOGGER.info("Registrando itens do mod " + Modaomod.MOD_ID);

//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries ->{
//            entries.add(PAMONHA);
//            entries.add(MILHO);
//            entries.add(SEMENTE_DE_MILHO);
//        });

    }


}
