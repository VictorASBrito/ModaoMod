package vitu.modao.util;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import vitu.modao.Modaomod;

public class ModTags {

    public static class Items{
        public static final TagKey<Item> WEAPON_ITEMS = createTag("weapon_items");


        private static TagKey<Item> createTag(String name){
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(Modaomod.MOD_ID, name));
        }
    }



}
