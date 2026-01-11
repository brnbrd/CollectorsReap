package net.brdle.collectorsreap.common.event;

import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CRSoundEvents {
	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, CollectorsReap.MODID);

	public static final RegistryObject<SoundEvent> STRAW_BRUSH_COLLECT = SOUNDS.register("straw_brush_collect",
		() -> SoundEvent.createVariableRangeEvent(Util.cr("item.straw_brush.collect")));
	public static final RegistryObject<SoundEvent> STRAW_BRUSH_POLLINATE = SOUNDS.register("straw_brush_pollinate",
		() -> SoundEvent.createVariableRangeEvent(Util.cr("item.straw_brush.pollinate")));
	public static final RegistryObject<SoundEvent> PICK_LIME = SOUNDS.register("pick_lime",
		() -> SoundEvent.createVariableRangeEvent(Util.cr("block.lime_bush.pick_lime")));
	public static final RegistryObject<SoundEvent> PICK_POMEGRANATE = SOUNDS.register("pick_pomegranate",
		() -> SoundEvent.createVariableRangeEvent(Util.cr("block.pomegranate_bush.pick_pomegranate")));
	public static final RegistryObject<SoundEvent> PICK_DRAGON_FRUIT = SOUNDS.register("pick_dragon_fruit",
		() -> SoundEvent.createVariableRangeEvent(Util.cr("block.dragon_fruit_bush.pick_dragon_fruit")));
	public static final RegistryObject<SoundEvent> URCHIN_DART_THROW = SOUNDS.register("urchin_dart_throw",
		() -> SoundEvent.createVariableRangeEvent(Util.cr("entity.urchin_dart.throw")));
	public static final RegistryObject<SoundEvent> URCHIN_DART_HIT = SOUNDS.register("urchin_dart_hit",
		() -> SoundEvent.createVariableRangeEvent(Util.cr("entity.urchin_dart.hit")));
	public static final RegistryObject<SoundEvent> SHIMMERING_PEARL_THROW = SOUNDS.register("shimmering_pearl_throw",
		() -> SoundEvent.createVariableRangeEvent(Util.cr("entity.shimmering_pearl.throw")));
	public static final RegistryObject<SoundEvent> SHIMMERING_PEARL_BREAK = SOUNDS.register("shimmering_pearl_break",
		() -> SoundEvent.createVariableRangeEvent(Util.cr("entity.shimmering_pearl.break")));
	public static final RegistryObject<SoundEvent> PLATINUM_BASS_DEATH = SOUNDS.register("platinum_bass_death",
		() -> SoundEvent.createVariableRangeEvent(Util.cr("entity.platinum_bass.death")));
	public static final RegistryObject<SoundEvent> PLATINUM_BASS_HURT = SOUNDS.register("platinum_bass_hurt",
		() -> SoundEvent.createVariableRangeEvent(Util.cr("entity.platinum_bass.hurt")));
	public static final RegistryObject<SoundEvent> PLATINUM_BASS_FLOP = SOUNDS.register("platinum_bass_flop",
		() -> SoundEvent.createVariableRangeEvent(Util.cr("entity.platinum_bass.flop")));
	public static final RegistryObject<SoundEvent> REBOUND_HEAL = SOUNDS.register("rebound_heal",
		() -> SoundEvent.createVariableRangeEvent(Util.cr("effect.rebound.heal")));
	public static final RegistryObject<SoundEvent> CORROSION_CORRODE = SOUNDS.register("corrosion_corrode",
		() -> SoundEvent.createVariableRangeEvent(Util.cr("effect.corrosion.corrode")));

	public static void create(IEventBus bus) {
		SOUNDS.register(bus);
	}
}