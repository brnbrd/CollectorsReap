package net.brdle.collectorsreap.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.brdle.collectorsreap.client.animation.PlatinumBassAnimation;
import net.brdle.collectorsreap.common.entity.PlatinumBass;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import org.jetbrains.annotations.NotNull;

public class PlatinumBassModel extends HierarchicalModel<PlatinumBass> {
	private final ModelPart body;
	private final ModelPart leftFin;
	private final ModelPart rightFin;
	private final ModelPart head;
	private final ModelPart tail;

	public PlatinumBassModel(ModelPart root) {
		this.body = root.getChild("Body");
		this.leftFin = this.body.getChild("LeftFin");
		this.rightFin = this.body.getChild("RightFin");
		this.head = this.body.getChild("Head");
		this.tail = this.body.getChild("Tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition body = mesh.getRoot().addOrReplaceChild("Body", CubeListBuilder.create()
			.texOffs(0, 0).addBox(-3F, -12F, -1F, 6F, 10F, 16F, new CubeDeformation(0F))
			.texOffs(0, 11).addBox(0F, -15F, 3F, 0F, 16F, 15F, new CubeDeformation(0F)),
			PartPose.offset(0F, 26F, -8F));
		body.addOrReplaceChild("LeftFin", CubeListBuilder.create()
			.texOffs(30, 26).addBox(0F, -3F, 0F, 0F, 6F, 6F, new CubeDeformation(0F)),
			PartPose.offsetAndRotation(3F, -6F, 0F, 0F, 0.6981F, 0F));
		body.addOrReplaceChild("RightFin", CubeListBuilder.create()
			.texOffs(30, 20).addBox(0F, -3F, 0F, 0F, 6F, 6F, new CubeDeformation(0F)),
			PartPose.offsetAndRotation(-3F, -6F, 0F, 0F, -0.6981F, 0F));
		body.addOrReplaceChild("Head", CubeListBuilder.create()
			.texOffs(0, 0).addBox(-2F, -2F, -7F, 4F, 4F, 1F, new CubeDeformation(0F))
			.texOffs(28, 0).addBox(-3F, -4F, -6F, 6F, 7F, 6F, new CubeDeformation(0F)),
			PartPose.offset(0F, -6F, -1F));
		body.addOrReplaceChild("Tail", CubeListBuilder.create()
			.texOffs(26, 38).addBox(-1F, -4F, 0F, 2F, 7F, 4F, new CubeDeformation(0F))
			.texOffs(0, 0).addBox(0F, -5F, 3F, 0F, 9F, 6F, new CubeDeformation(0F)),
			PartPose.offset(0F, -6F, 15F));
		return LayerDefinition.create(mesh, 64, 64);
	}

	@Override
	public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public @NotNull ModelPart root() {
		return this.body;
	}

	@Override
	public void setupAnim(PlatinumBass entity, float pLimbSwing, float pLimbSwingAmount, float age, float pNetHeadYaw, float pHeadPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animate(entity.swimAnimationState, PlatinumBassAnimation.MODEL_SWIM, age);
		this.animate(entity.drownAnimationState, PlatinumBassAnimation.MODEL_DROWN, age);
	}
}