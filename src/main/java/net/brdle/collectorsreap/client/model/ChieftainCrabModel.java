package net.brdle.collectorsreap.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.brdle.collectorsreap.client.animation.ChieftainCrabAnimation;
import net.brdle.collectorsreap.common.entity.ChieftainCrab;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import org.jetbrains.annotations.NotNull;

public class ChieftainCrabModel extends HierarchicalModel<ChieftainCrab> {
	private final ModelPart body;
	private final ModelPart main;
	private final ModelPart bodyside2;
	private final ModelPart bodyside;
	private final ModelPart eyes;
	private final ModelPart leftArm;
	private final ModelPart leftArm2;
	private final ModelPart leftPincer;
	private final ModelPart bone3;
	private final ModelPart rightArm;
	private final ModelPart rightArm2;
	private final ModelPart rightPincer;
	private final ModelPart bone2;
	private final ModelPart rightLeg1;
	private final ModelPart bone;
	private final ModelPart rightLeg2;
	private final ModelPart bone4;
	private final ModelPart rightLeg3;
	private final ModelPart bone5;
	private final ModelPart rightLeg4;
	private final ModelPart bone6;
	private final ModelPart leftLeg1;
	private final ModelPart bone7;
	private final ModelPart leftLeg2;
	private final ModelPart bone8;
	private final ModelPart leftLeg3;
	private final ModelPart bone9;
	private final ModelPart leftLeg4;
	private final ModelPart bone10;


	public ChieftainCrabModel(ModelPart root) {
		super(RenderType::entityCutoutNoCull);
		this.body = root.getChild("Body");
		this.main = body.getChild("Main");
		this.bodyside2 = main.getChild("bodyside2");
		this.bodyside = main.getChild("bodyside");
		this.eyes = main.getChild("eyes");
		this.leftArm = body.getChild("LeftArm");
		this.leftArm2 = leftArm.getChild("LeftArm2");
		this.leftPincer = leftArm2.getChild("LeftPincer");
		this.bone3 = leftPincer.getChild("bone3");
		this.rightArm = body.getChild("RightArm");
		this.rightArm2 = rightArm.getChild("RightArm2");
		this.rightPincer = rightArm2.getChild("RightPincer");
		this.bone2 = rightPincer.getChild("bone2");
		this.rightLeg1 = body.getChild("RightLeg1");
		this.bone = rightLeg1.getChild("bone");
		this.rightLeg2 = body.getChild("RightLeg2");
		this.bone4 = rightLeg2.getChild("bone4");
		this.rightLeg3 = body.getChild("RightLeg3");
		this.bone5 = rightLeg3.getChild("bone5");
		this.rightLeg4 = body.getChild("RightLeg4");
		this.bone6 = rightLeg4.getChild("bone6");
		this.leftLeg1 = body.getChild("LeftLeg1");
		this.bone7 = leftLeg1.getChild("bone7");
		this.leftLeg2 = body.getChild("LeftLeg2");
		this.bone8 = leftLeg2.getChild("bone8");
		this.leftLeg3 = body.getChild("LeftLeg3");
		this.bone9 = leftLeg3.getChild("bone9");
		this.leftLeg4 = body.getChild("LeftLeg4");
		this.bone10 = leftLeg4.getChild("bone10");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition root = meshdefinition.getRoot();
		PartDefinition body = root.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, 22.0F, 0.0F));
		PartDefinition Main = body.addOrReplaceChild("Main", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -13.0F, -7.0F, 14.0F, 7.0F, 11.0F, new CubeDeformation(0.01F))
			.texOffs(0, 56).addBox(-6.0F, -12.0F, 4.0F, 12.0F, 6.0F, 3.0F, new CubeDeformation(0.01F))
			.texOffs(32, 26).addBox(-7.0F, -6.0F, -5.0F, 14.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition bodyside2 = Main.addOrReplaceChild("bodyside2", CubeListBuilder.create().texOffs(40, 38).addBox(0.0F, -12.0F, 0.0F, 6.0F, 6.0F, 14.0F, new CubeDeformation(0.0F))
			.texOffs(12, 18).addBox(2.0F, -11.0F, -2.0F, 6.0F, 0.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 0.0F, -7.0F, 0.0F, -0.3491F, 0.0F));
		PartDefinition bodyside = Main.addOrReplaceChild("bodyside", CubeListBuilder.create().texOffs(0, 36).addBox(-6.0F, -12.0F, 0.0F, 6.0F, 6.0F, 14.0F, new CubeDeformation(0.0F))
			.texOffs(0, 18).addBox(-8.0F, -11.0F, -2.0F, 6.0F, 0.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, 0.0F, -7.0F, 0.0F, 0.3491F, 0.0F));
		PartDefinition eyes = Main.addOrReplaceChild("eyes", CubeListBuilder.create().texOffs(4, 26).addBox(-3.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
			.texOffs(0, 26).addBox(2.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, -7.0F, 0.6109F, 0.0F, 0.0F));
		PartDefinition LeftArm = body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(0, 22).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, -8.0F, -6.0F, 0.0F, 0.1745F, 0.0F));
		PartDefinition LeftArm2 = LeftArm.addOrReplaceChild("LeftArm2", CubeListBuilder.create().texOffs(30, 58).addBox(-1.0F, -2.0F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
		PartDefinition LeftPincer = LeftArm2.addOrReplaceChild("LeftPincer", CubeListBuilder.create().texOffs(50, 0).addBox(-1.0F, -3.0F, -3.0F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.01F))
			.texOffs(70, 20).addBox(8.0F, 0.0F, -2.0F, 7.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 0.0F, 0.0F, 0.0F, 2.138F, 0.0F));
		PartDefinition bone3 = LeftPincer.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(0, 65).addBox(-1.0F, -3.0F, -2.0F, 8.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
			.texOffs(0, 5).addBox(7.0F, -2.0F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 0.0F, 0.0F));
		PartDefinition RightArm = body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(0, 18).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, -8.0F, -6.0F, 0.0F, -0.1745F, 0.0F));
		PartDefinition RightArm2 = RightArm.addOrReplaceChild("RightArm2", CubeListBuilder.create().texOffs(26, 38).addBox(-8.0F, -2.0F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, -0.3927F, 0.0F));
		PartDefinition RightPincer = RightArm2.addOrReplaceChild("RightPincer", CubeListBuilder.create().texOffs(44, 12).addBox(-8.0F, -3.0F, -3.0F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.01F))
			.texOffs(20, 70).addBox(-15.0F, 0.0F, -2.0F, 7.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 0.0F, 0.0F, 0.0F, -2.138F, 0.0F));
		PartDefinition bone2 = RightPincer.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(56, 58).addBox(-7.0F, -3.0F, -2.0F, 8.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
			.texOffs(0, 0).addBox(-10.0F, -2.0F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, 0.0F, 0.0F));
		PartDefinition RightLeg1 = body.addOrReplaceChild("RightLeg1", CubeListBuilder.create().texOffs(76, 69).addBox(-10.0F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -4.0F, -4.0F, 0.0F, -0.2618F, 0.1745F));
		PartDefinition bone = RightLeg1.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(50, 69).addBox(-12.0F, -1.0F, 0.0F, 13.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, 0.0F, 0.0F, -0.2618F, 0.0F, -0.6109F));
		PartDefinition RightLeg2 = body.addOrReplaceChild("RightLeg2", CubeListBuilder.create().texOffs(76, 69).addBox(-10.0F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -4.0F, -1.0F, 0.0F, -0.0873F, 0.2182F));
		PartDefinition bone4 = RightLeg2.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(50, 69).addBox(-12.0F, -1.0F, 0.0F, 13.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, 0.0F, 0.0F, 0.2597F, 0.0338F, -0.7374F));
		PartDefinition RightLeg3 = body.addOrReplaceChild("RightLeg3", CubeListBuilder.create().texOffs(76, 69).addBox(-10.0F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -4.0F, 2.0F, 0.0F, 0.0873F, 0.2618F));
		PartDefinition bone5 = RightLeg3.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(50, 69).addBox(-12.0F, -1.0F, 0.0F, 13.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, 0.0F, 0.0F, 0.2502F, 0.0779F, -0.8192F));
		PartDefinition RightLeg4 = body.addOrReplaceChild("RightLeg4", CubeListBuilder.create().texOffs(76, 69).addBox(-10.0F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -4.0F, 5.0F, 0.0F, 0.2618F, 0.4363F));
		PartDefinition bone6 = RightLeg4.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(50, 69).addBox(-12.0F, -1.0F, 0.0F, 13.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, 0.0F, 0.0F, 0.2223F, 0.1395F, -1.1625F));
		PartDefinition LeftLeg1 = body.addOrReplaceChild("LeftLeg1", CubeListBuilder.create().texOffs(66, 73).addBox(0.0F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -4.0F, -4.0F, 0.0F, 0.2618F, -0.1745F));
		PartDefinition bone7 = LeftLeg1.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(66, 38).addBox(-1.0F, -1.0F, 0.0F, 13.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0F, 0.0F, 0.0F, -0.2618F, 0.0F, 0.6109F));
		PartDefinition LeftLeg2 = body.addOrReplaceChild("LeftLeg2", CubeListBuilder.create().texOffs(66, 73).addBox(0.0F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -4.0F, -1.0F, 0.0F, 0.0873F, -0.2182F));
		PartDefinition bone8 = LeftLeg2.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(66, 38).addBox(-1.0F, -1.0F, 0.0F, 13.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0F, 0.0F, 0.0F, 0.2597F, -0.0338F, 0.7374F));
		PartDefinition LeftLeg3 = body.addOrReplaceChild("LeftLeg3", CubeListBuilder.create().texOffs(66, 73).addBox(0.0F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -4.0F, 2.0F, 0.0F, -0.0873F, -0.2618F));
		PartDefinition bone9 = LeftLeg3.addOrReplaceChild("bone9", CubeListBuilder.create().texOffs(66, 38).addBox(-1.0F, -1.0F, 0.0F, 13.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0F, 0.0F, 0.0F, 0.2559F, -0.056F, 0.8218F));
		PartDefinition LeftLeg4 = body.addOrReplaceChild("LeftLeg4", CubeListBuilder.create().texOffs(66, 73).addBox(0.0F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -4.0F, 5.0F, 0.0F, -0.2618F, -0.4363F));
		PartDefinition bone10 = LeftLeg4.addOrReplaceChild("bone10", CubeListBuilder.create().texOffs(66, 38).addBox(-1.0F, -1.0F, 0.0F, 13.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0F, 0.0F, 0.0F, 0.2223F, -0.1395F, 1.1625F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public @NotNull ModelPart root() {
		return body;
	}

	@Override
	public void setupAnim(@NotNull ChieftainCrab entity, float limbSwing, float limbSwingAmount, float age, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animate(entity.idleAnimationState, ChieftainCrabAnimation.CHIEFTAINCRAB_IDLE, age);
		this.animate(entity.movingAnimationState, ChieftainCrabAnimation.CHIEFTAINCRAB_WALK, age);
	}
}