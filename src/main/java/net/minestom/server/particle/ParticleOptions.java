package net.minestom.server.particle;

import net.minestom.server.color.Color;
import net.minestom.server.coordinate.Point;
import net.minestom.server.item.ItemStack;
import net.minestom.server.utils.MathUtils;
import net.minestom.server.utils.binary.BinaryWriter;
import net.minestom.server.utils.binary.Writeable;
import net.minestom.server.utils.validate.Check;
import org.jetbrains.annotations.NotNull;

import static net.minestom.server.particle.ParticleOptions.*;

public sealed interface ParticleOptions extends Writeable permits AMBIENT_ENTITY_EFFECT, ANGRY_VILLAGER, ASH, BLOCK, BLOCK_MARKER, BUBBLE, BUBBLE_COLUMN_UP, BUBBLE_POP, CAMPFIRE_COSY_SMOKE, CAMPFIRE_SIGNAL_SMOKE, CLOUD, COMPOSTER, CRIMSON_SPORE, CRIT, CURRENT_DOWN, DAMAGE_INDICATOR, DOLPHIN, DRAGON_BREATH, DRIPPING_DRIPSTONE_LAVA, DRIPPING_DRIPSTONE_WATER, DRIPPING_HONEY, DRIPPING_LAVA, DRIPPING_OBSIDIAN_TEAR, DRIPPING_WATER, DUST, DUST_COLOR_TRANSITION, EFFECT, ELDER_GUARDIAN, ELECTRIC_SPARK, ENCHANT, ENCHANTED_HIT, END_ROD, ENTITY_EFFECT, EXPLOSION, EXPLOSION_EMITTER, FALLING_DRIPSTONE_LAVA, FALLING_DRIPSTONE_WATER, FALLING_DUST, FALLING_HONEY, FALLING_LAVA, FALLING_NECTAR, FALLING_OBSIDIAN_TEAR, FALLING_SPORE_BLOSSOM, FALLING_WATER, FIREWORK, FISHING, FLAME, FLASH, GLOW, GLOW_SQUID_INK, HAPPY_VILLAGER, HEART, INSTANT_EFFECT, ITEM, ITEM_SLIME, ITEM_SNOWBALL, LANDING_HONEY, LANDING_LAVA, LANDING_OBSIDIAN_TEAR, LARGE_SMOKE, LAVA, MYCELIUM, NAUTILUS, NOTE, POOF, PORTAL, RAIN, REVERSE_PORTAL, SCRAPE, SCULK_CHARGE, SCULK_CHARGE_POP, SCULK_SOUL, SHRIEK, SMALL_FLAME, SMOKE, SNEEZE, SNOWFLAKE, SONIC_BOOM, SOUL, SOUL_FIRE_FLAME, SPIT, SPLASH, SPORE_BLOSSOM_AIR, SQUID_INK, SWEEP_ATTACK, TOTEM_OF_UNDYING, UNDERWATER, VIBRATION, WARPED_SPORE, WAX_OFF, WAX_ON, WHITE_ASH, WITCH {

    Particle type();

    default void write(@NotNull BinaryWriter writer) {

    }

    record AMBIENT_ENTITY_EFFECT() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.AMBIENT_ENTITY_EFFECT;
        }
    }

    record ANGRY_VILLAGER() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.ANGRY_VILLAGER;
        }
    }

    record BLOCK(net.minestom.server.instance.block.Block block) implements ParticleOptions {

        @Override
        public void write(@NotNull BinaryWriter writer) {
            writer.writeVarInt(block.id());
        }

        @Override
        public Particle type() {
            return Particle.BLOCK;
        }
    }

    record BLOCK_MARKER(net.minestom.server.instance.block.Block block) implements ParticleOptions {

        @Override
        public void write(@NotNull BinaryWriter writer) {
            writer.writeVarInt(block.id());
        }

        @Override
        public Particle type() {
            return Particle.BLOCK_MARKER;
        }
    }

    record BUBBLE() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.BUBBLE;
        }
    }

    record CLOUD() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.CLOUD;
        }
    }

    record CRIT() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.CRIT;
        }
    }

    record DAMAGE_INDICATOR() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.DAMAGE_INDICATOR;
        }
    }

    record DRAGON_BREATH() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.DRAGON_BREATH;
        }
    }

    record DRIPPING_LAVA() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.DRIPPING_LAVA;
        }
    }

    record FALLING_LAVA() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.FALLING_LAVA;
        }
    }

    record LANDING_LAVA() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.LANDING_LAVA;
        }
    }

    record DRIPPING_WATER() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.DRIPPING_WATER;
        }
    }

    record FALLING_WATER() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.FALLING_WATER;
        }
    }

    record DUST(Color color, float scale) implements ParticleOptions {

        @Override
        public Particle type() {
            return Particle.DUST;
        }

        @Override
        public void write(@NotNull BinaryWriter writer) {
            writer.writeColor(color);
            writer.writeFloat(Math.min(4f, scale));
        }
    }

    record DUST_COLOR_TRANSITION(Color from, Color to, float scale) implements ParticleOptions {

        @Override
        public void write(@NotNull BinaryWriter writer) {
            writer.writeColor(from);
            writer.writeFloat(Math.max(0.01f, Math.min(4f, scale)));
            writer.writeColor(to);
        }

        @Override
        public Particle type() {
            return Particle.DUST_COLOR_TRANSITION;
        }
    }

    record EFFECT() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.EFFECT;
        }
    }

    record ELDER_GUARDIAN() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.ELDER_GUARDIAN;
        }
    }

    record ENCHANTED_HIT() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.ENCHANTED_HIT;
        }
    }

    record ENCHANT() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.ENCHANT;
        }
    }

    record END_ROD() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.END_ROD;
        }
    }

    record ENTITY_EFFECT() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.ENTITY_EFFECT;
        }
    }

    record EXPLOSION_EMITTER() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.EXPLOSION_EMITTER;
        }
    }

    record EXPLOSION() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.EXPLOSION;
        }
    }

    record SONIC_BOOM() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.SONIC_BOOM;
        }
    }

    record FALLING_DUST(net.minestom.server.instance.block.Block block) implements ParticleOptions {

        @Override
        public void write(@NotNull BinaryWriter writer) {
            writer.writeVarInt(block.id());
        }

        @Override
        public Particle type() {
            return Particle.FALLING_DUST;
        }
    }

    record FIREWORK() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.FIREWORK;
        }
    }

    record FISHING() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.FISHING;
        }
    }

    record FLAME() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.FLAME;
        }
    }

    record SCULK_SOUL() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.SCULK_SOUL;
        }
    }

    record SCULK_CHARGE(float angle) implements ParticleOptions {

        public SCULK_CHARGE {
            Check.argCondition(MathUtils.isBetween(angle, 0, 2 * Math.PI), "Angle is not within bounds");
        }

        @Override
        public void write(@NotNull BinaryWriter writer) {
            writer.writeFloat(angle);
        }

        @Override
        public Particle type() {
            return Particle.SCULK_CHARGE;
        }
    }

    record SCULK_CHARGE_POP() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.SCULK_CHARGE_POP;
        }
    }

    record SOUL_FIRE_FLAME() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.SOUL_FIRE_FLAME;
        }
    }

    record SOUL() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.SOUL;
        }
    }

    record FLASH() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.FLASH;
        }
    }

    record HAPPY_VILLAGER() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.HAPPY_VILLAGER;
        }
    }

    record COMPOSTER() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.COMPOSTER;
        }
    }

    record HEART() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.HEART;
        }
    }

    record INSTANT_EFFECT() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.INSTANT_EFFECT;
        }
    }

    record ITEM(ItemStack item) implements ParticleOptions {

        @Override
        public void write(@NotNull BinaryWriter writer) {
            writer.writeItemStack(item);
        }

        @Override
        public Particle type() {
            return Particle.ITEM;
        }
    }

    record VIBRATION(Target target, int ticks) implements ParticleOptions {

        private sealed interface Target extends Writeable permits Block, Entity {
        }

        public record Block(Point blockPosition) implements Target {

            @Override
            public void write(@NotNull BinaryWriter writer) {
                writer.writeSizedString("minecraft:block");
                writer.writeBlockPosition(blockPosition);
            }
        }

        public record Entity(int entityId, float eyeHeight) implements Target {

            public Entity(@NotNull net.minestom.server.entity.Entity e) {
                this(e.getEntityId(), (float) e.getEyeHeight());
            }

            @Override
            public void write(@NotNull BinaryWriter writer) {
                writer.writeSizedString("minecraft:entity");
                writer.writeVarInt(entityId);
                writer.writeFloat(eyeHeight);
            }
        }

        @Override
        public void write(@NotNull BinaryWriter writer) {
            target.write(writer);
            writer.writeVarInt(ticks);
        }

        @Override
        public Particle type() {
            return Particle.VIBRATION;
        }
    }

    record ITEM_SLIME() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.ITEM_SLIME;
        }
    }

    record ITEM_SNOWBALL() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.ITEM_SNOWBALL;
        }
    }

    record LARGE_SMOKE() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.LARGE_SMOKE;
        }
    }

    record LAVA() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.LAVA;
        }
    }

    record MYCELIUM() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.MYCELIUM;
        }
    }

    record NOTE() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.NOTE;
        }
    }

    record POOF() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.POOF;
        }
    }

    record PORTAL() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.PORTAL;
        }
    }

    record RAIN() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.RAIN;
        }
    }

    record SMOKE() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.SMOKE;
        }
    }

    record SNEEZE() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.SNEEZE;
        }
    }

    record SPIT() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.SPIT;
        }
    }

    record SQUID_INK() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.SQUID_INK;
        }
    }

    record SWEEP_ATTACK() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.SWEEP_ATTACK;
        }
    }

    record TOTEM_OF_UNDYING() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.TOTEM_OF_UNDYING;
        }
    }

    record UNDERWATER() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.UNDERWATER;
        }
    }

    record SPLASH() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.SPLASH;
        }
    }

    record WITCH() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.WITCH;
        }
    }

    record BUBBLE_POP() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.BUBBLE_POP;
        }
    }

    record CURRENT_DOWN() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.CURRENT_DOWN;
        }
    }

    record BUBBLE_COLUMN_UP() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.BUBBLE_COLUMN_UP;
        }
    }

    record NAUTILUS() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.NAUTILUS;
        }
    }

    record DOLPHIN() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.DOLPHIN;
        }
    }

    record CAMPFIRE_COSY_SMOKE() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.CAMPFIRE_COSY_SMOKE;
        }
    }

    record CAMPFIRE_SIGNAL_SMOKE() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.CAMPFIRE_SIGNAL_SMOKE;
        }
    }

    record DRIPPING_HONEY() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.DRIPPING_HONEY;
        }
    }

    record FALLING_HONEY() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.FALLING_HONEY;
        }
    }

    record LANDING_HONEY() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.LANDING_HONEY;
        }
    }

    record FALLING_NECTAR() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.FALLING_NECTAR;
        }
    }

    record FALLING_SPORE_BLOSSOM() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.FALLING_SPORE_BLOSSOM;
        }
    }

    record ASH() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.ASH;
        }
    }

    record CRIMSON_SPORE() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.CRIMSON_SPORE;
        }
    }

    record WARPED_SPORE() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.WARPED_SPORE;
        }
    }

    record SPORE_BLOSSOM_AIR() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.SPORE_BLOSSOM_AIR;
        }
    }

    record DRIPPING_OBSIDIAN_TEAR() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.DRIPPING_OBSIDIAN_TEAR;
        }
    }

    record FALLING_OBSIDIAN_TEAR() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.FALLING_OBSIDIAN_TEAR;
        }
    }

    record LANDING_OBSIDIAN_TEAR() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.LANDING_OBSIDIAN_TEAR;
        }
    }

    record REVERSE_PORTAL() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.REVERSE_PORTAL;
        }
    }

    record WHITE_ASH() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.WHITE_ASH;
        }
    }

    record SMALL_FLAME() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.SMALL_FLAME;
        }
    }

    record SNOWFLAKE() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.SNOWFLAKE;
        }
    }

    record DRIPPING_DRIPSTONE_LAVA() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.DRIPPING_DRIPSTONE_LAVA;
        }
    }

    record FALLING_DRIPSTONE_LAVA() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.FALLING_DRIPSTONE_LAVA;
        }
    }

    record DRIPPING_DRIPSTONE_WATER() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.DRIPPING_DRIPSTONE_WATER;
        }
    }

    record FALLING_DRIPSTONE_WATER() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.FALLING_DRIPSTONE_WATER;
        }
    }

    record GLOW_SQUID_INK() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.GLOW_SQUID_INK;
        }
    }

    record GLOW() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.GLOW;
        }
    }

    record WAX_ON() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.WAX_ON;
        }
    }

    record WAX_OFF() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.WAX_OFF;
        }
    }

    record ELECTRIC_SPARK() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.ELECTRIC_SPARK;
        }
    }

    record SCRAPE() implements ParticleOptions {
        @Override
        public Particle type() {
            return Particle.SCRAPE;
        }
    }

    record SHRIEK(int ticks) implements ParticleOptions {

        @Override
        public void write(@NotNull BinaryWriter writer) {
            writer.writeVarInt(ticks);
        }

        @Override
        public Particle type() {
            return Particle.SHRIEK;
        }
    }
}