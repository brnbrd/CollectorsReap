package net.brdle.collectorsreap.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@OnlyIn(Dist.CLIENT)
public class SurgeParticle extends TextureSheetParticle {
	private final SpriteSet sprites;

	SurgeParticle(ClientLevel level, double x, double y, double z, SpriteSet sprites) {
		super(level, x, y, z);
		this.hasPhysics = false;
		this.gravity = 0F;
		this.friction = 1F;
		this.sprites = sprites;
		this.lifetime = 7;
		this.setSpriteFromAge(sprites);
	}

	public void tick() {
		super.tick();
		this.setSpriteFromAge(this.sprites);
	}

	@Override
	public @NotNull ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
	}

	@OnlyIn(Dist.CLIENT)
	public static class Provider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet sprites;

		public Provider(SpriteSet sprites) {
			this.sprites = sprites;
		}

		@Override
		public @Nullable Particle createParticle(@NotNull SimpleParticleType type, @NotNull ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			return new SurgeParticle(level, x, y, z, this.sprites);
		}
	}
}