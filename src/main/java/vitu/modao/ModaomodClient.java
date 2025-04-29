package vitu.modao;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;
import vitu.modao.item.ModItems;

public class ModaomodClient implements ClientModInitializer {
    public static KeyBinding specialAbility;

    @Override
    public void onInitializeClient() {
        specialAbility = new KeyBinding(
            "key.modaomod.habilidadeespecial",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_R,
                "category.modaomod"
                );

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (specialAbility.wasPressed()) {
                if (client.player != null) {
                    ItemStack heldItem = client.player.getMainHandStack();

                  if (heldItem.isOf(ModItems.TAEWON_ABILITY)){
                      client.player.setStackInHand(client.player.getActiveHand(), new ItemStack(ModItems.TAEWON_LANCE));
                  }else if (heldItem.isOf(ModItems.TAEWON_LANCE)){
                      client.player.setStackInHand(client.player.getActiveHand(), new ItemStack(ModItems.TAEWON_ABILITY));
                  }
                }
            }
        });


    }
}