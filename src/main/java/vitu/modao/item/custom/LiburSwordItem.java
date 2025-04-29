package vitu.modao.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import vitu.modao.item.ModItems;

import java.util.List;

public class LiburSwordItem extends Item {
    private static final int ATTACK_DAMAGE_MODIFIER_VALUE = 5;
    private static final float ATTACK_SPEED_MODIFIER_VALUE = -3.4F;
    public static final float MINING_SPEED_MULTIPLIER = 1.5F;
    private static final float field_50141 = 5.0F;
    public static final float KNOCKBACK_RANGE = 3.5F;
    private static final float KNOCKBACK_POWER = 0.7F;

    public LiburSwordItem(Settings settings) { super(settings); }

    public static AttributeModifiersComponent createAttributeModifiers() {
        return AttributeModifiersComponent.builder()
                .add(
                        EntityAttributes.GENERIC_ATTACK_DAMAGE,
                        new EntityAttributeModifier(BASE_ATTACK_DAMAGE_MODIFIER_ID, 9.0, EntityAttributeModifier.Operation.ADD_VALUE),
                        AttributeModifierSlot.MAINHAND
                )
                .add(
                        EntityAttributes.GENERIC_ATTACK_SPEED,
                        new EntityAttributeModifier(BASE_ATTACK_SPEED_MODIFIER_ID, -2.4F, EntityAttributeModifier.Operation.ADD_VALUE),
                        AttributeModifierSlot.MAINHAND
                )
                .build();
    }

    public static ToolComponent createToolComponent() {
        return new ToolComponent(List.of(), 1.0F, 2);
    }


    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = attacker.getWorld();
        if (!world.isClient && attacker instanceof PlayerEntity player) {

            // Direção que o jogador está olhando
            Vec3d attackerLook = attacker.getRotationVec(1.0F).normalize();
            double range = 3.0;

            List<LivingEntity> entities = world.getEntitiesByClass(
                    LivingEntity.class,
                    attacker.getBoundingBox().expand(range, 0.25, range),
                    entity -> {
                        if (entity == attacker || entity == target || !entity.isAlive()) return false;

                        // Vetor do atacante até o inimigo
                        Vec3d directionToEntity = entity.getPos().subtract(attacker.getPos()).normalize();

                        // ângulo entre a visão do jogador e o alvo (quanto mais perto de 1, mais na frente)
                        double dot = attackerLook.dotProduct(directionToEntity);

                        return dot > 0.4; // só pega quem estiver num cone à frente (~60 graus)
                    }
            );

            for (LivingEntity entity : entities) {
                entity.damage(((ServerWorld) world).getDamageSources().playerAttack(player), 4.0F);
                entity.takeKnockback(0.4F, attacker.getX() - entity.getX(), attacker.getZ() - entity.getZ());
            }

        }

        return super.postHit(stack, target, attacker);
    }


    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return !miner.isCreative();
    }

    @Override
    public int getEnchantability() {
        return 15;
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.isOf(ModItems.ALMA);
    }


}
