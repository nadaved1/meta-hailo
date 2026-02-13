SUMMARY = "Hailo C++ standalone applications"
DESCRIPTION = "Standalone C++ applications from the hailo-apps repository for Hailo-8 accelerator"
HOMEPAGE = "https://github.com/hailo-ai/hailo-apps"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# Dependencies
DEPENDS = "libhailort opencv xtensor xtl "
# Runtime dependencies
RDEPENDS:${PN} = "libhailort opencv "

# Source repository
SRC_URI = "git://github.com/hailo-ai/hailo-apps.git;protocol=https;branch=main"

# Needed for the pose-estimation and seg apps
SRC_URI += "\
    file://0001-fix-xtensor-include.patch \
"

MZ_VERSION = "v2.17.0"

# Download HEF files for the different apps
SRC_URI += "\
    https://hailo-model-zoo.s3.eu-west-2.amazonaws.com/ModelZoo/Compiled/${MZ_VERSION}/${HAILO_DEVICE}/fastvit_sa12.hef;name=fastvit_sa12 \
    https://hailo-model-zoo.s3.eu-west-2.amazonaws.com/ModelZoo/Compiled/${MZ_VERSION}/${HAILO_DEVICE}/yolov8m.hef;name=yolov8m \
    https://hailo-model-zoo.s3.eu-west-2.amazonaws.com/ModelZoo/Compiled/${MZ_VERSION}/${HAILO_DEVICE}/yolov8s_pose.hef;name=yolov8s_pose \
    https://hailo-model-zoo.s3.eu-west-2.amazonaws.com/ModelZoo/Compiled/${MZ_VERSION}/${HAILO_DEVICE}/fcn8_resnet_v1_18.hef;name=fcn8_resnet_v1_18 \
    https://hailo-model-zoo.s3.eu-west-2.amazonaws.com/ModelZoo/Compiled/${MZ_VERSION}/${HAILO_DEVICE}/yolov5m_seg.hef;name=yolov5m_seg \
    https://hailo-model-zoo.s3.eu-west-2.amazonaws.com/ModelZoo/Compiled/${MZ_VERSION}/${HAILO_DEVICE}/scdepthv3.hef;name=scdepthv3 \
    https://hailo-csdata.s3.eu-west-2.amazonaws.com/resources/hefs/h8/hailo_yolov8n_4_classes_vga.hef;name=hailo_yolov8n_4_classes_vga \
    https://hailo-csdata.s3.eu-west-2.amazonaws.com/resources/hefs/h8/yolo11s_obb.hef;name=yolo11s_obb \
"
SRC_URI[fastvit_sa12.sha256sum] = "1372f0f27d239488d17293cdba1cb6ad8c609629e76226c04e242e89fdd63493"
SRC_URI[yolov8m.sha256sum] = "9481dbff7798d90302e170958943578d444b61c9833c67fef36075fe129efe7f"
SRC_URI[yolov8s_pose.sha256sum] = "0ea260234250510c34140ea0e723b9d4a1e74ca13c37b3c8279200dd972f5381"
SRC_URI[fcn8_resnet_v1_18.sha256sum] = "be504f99bc92bb32ba2cbfc88267e19f5c6db1b3a0643a9d6e9949a5883f7d5a"
SRC_URI[yolov5m_seg.sha256sum] = "7c9160d89dc36b7fe7651eed680c7c1b2c96f4269c23fa67de9101ef7a5cf57e"
SRC_URI[scdepthv3.sha256sum] = "5b88f3b8975bf5869d86f2c2d1c21cfbc24e548eaf14d945ec08531bbe445cae"
SRC_URI[yolo11s_obb.sha256sum] = "546653b5d66c59b2e2731d1435efc13d6d7aa5f7a7468c99ff83cff8e4f23dfc"
#SRC_URI[clip_vit_b_32_image_encoder.sha256sum] = "841e79e202dd3751e5ceceb12e3b56db0f4d02bc8cb0b226a723d1e82ee7ea70"
#SRC_URI[clip_vit_b_32_text_encoder.sha256sum] = "4be9dbc51533571d0902a345c37f4a147ee0f79a438b1e1e7072a045b77433cb"
SRC_URI[hailo_yolov8n_4_classes_vga.sha256sum] = "62049ac5d2d7ccff3102c136634b7d88d9ad992dc72336ee24d76e0ee59441c2"

# Files for CLIP
SRC_URI += "\
    https://hailo-csdata.s3.eu-west-2.amazonaws.com/resources/images/bus.jpg;name=bus \
    https://hailo-csdata.s3.eu-west-2.amazonaws.com/resources/hefs/h8/clip_text_encoder_vit_l_14_laion2B.hef;name=clip_text_encoder_vit_l_14_laion2B \
    https://hailo-csdata.s3.eu-west-2.amazonaws.com/resources/hefs/h8/clip_vit_l_14_laion2B_image_encoder.hef;name=clip_vit_l_14_laion2B_image_encoder \
    https://hailo-csdata.s3.eu-west-2.amazonaws.com/resources/external+bin+files/text_projection.bin;name=text_projection \
    https://hailo-csdata.s3.eu-west-2.amazonaws.com/resources/npy+files/embedding_weights.npy;name=embedding_weights \
    https://hailo-csdata.s3.eu-west-2.amazonaws.com/resources/txt+files/bpe_simple_vocab_16e6.txt;name=bpe_simple_vocab_16e6 \
"
SRC_URI[bus.sha256sum] = "33b198a1d2839bb9ac4c65d61f9e852196793cae9a0781360859425f6022b69c"
SRC_URI[clip_text_encoder_vit_l_14_laion2B.sha256sum] = "1b42247a51d7bbf9b6b5e52a60f8af577a192fe0ad63459936ff889c42a17349"
SRC_URI[clip_vit_l_14_laion2B_image_encoder.sha256sum] = "95fde73753b7b9fcfd05f84db3ca72d622347e8ad8c83f8b074053f618b1e9ae"
SRC_URI[text_projection.sha256sum] = "c7676f9eb6161c57bbe84c7a8429e34c735e2d8a7f054b2aa3c2cca05209e6cc"
SRC_URI[embedding_weights.sha256sum] = "7c27d45e1ef8ed751d1916b8bec450b30b48b28e9fb4ea366ac2cdbefbb1954f"
SRC_URI[bpe_simple_vocab_16e6.sha256sum] = "67603cfda2e032ad77b5f8808af37789d590db664b26df8705d2bf8b3c553fc8"

SRCREV = "${AUTOREV}"

HAILO_CPP_ROOT      = "${WORKDIR}/git/hailo_apps/cpp"
HAILO_CPP_APPS      = "\
    pose_estimation \
    object_detection \
    classification \
    oriented_object_detection \
    semantic_segmentation \
    instance_segmentation \
    zero_shot_classification \
    depth_estimation_mono \
"
#    onnxrt_hailo_pipeline
inherit pkgconfig cmake

EXTRA_OECMAKE += "\
    -DCMAKE_BUILD_TYPE=RelWithDebInfo \
    -DCMAKE_C_FLAGS_INIT='${CFLAGS}' \
    -DCMAKE_CXX_FLAGS_INIT='${CXXFLAGS}' \
    -DCMAKE_EXE_LINKER_FLAGS_INIT='${LDFLAGS}' \
    -DCMAKE_PREFIX_PATH='${STAGING_DIR_TARGET}${prefix};${STAGING_DIR_TARGET}' \
"

do_configure() {
    CMAKE_BIN="${STAGING_BINDIR_NATIVE}/cmake"

    for app in ${HAILO_CPP_APPS}; do
        src_dir="${HAILO_CPP_ROOT}/${app}"
        bld_dir="${WORKDIR}/build/${app}"

        if [ ! -d "${src_dir}" ]; then
            bbfatal "App directory not found: ${src_dir}"
        fi

        install -d "${bld_dir}"

        ${CMAKE_BIN} -S "${src_dir}" -B "${bld_dir}" \
            -DCMAKE_BUILD_TYPE=RelWithDebInfo \
            -DCMAKE_C_FLAGS_INIT="${CFLAGS}" \
            -DCMAKE_CXX_FLAGS_INIT="${CXXFLAGS}" \
            -DCMAKE_EXE_LINKER_FLAGS_INIT="${LDFLAGS}" \
            ${EXTRA_OECMAKE}
    done
}

do_compile() {
    CMAKE_BIN="${STAGING_BINDIR_NATIVE}/cmake"

    for app in ${HAILO_CPP_APPS}; do
        bld_dir="${WORKDIR}/build/${app}"
        ${CMAKE_BIN} --build "${bld_dir}" -- -j ${@oe.utils.cpu_count()}
    done
}

do_install() {
    install -d ${D}/hailo-apps/zero_shot_classification
    install -d ${D}/usr/local/hailo/resources/models/${HAILO_DEVICE}
    install -m 0644 ${WORKDIR}/fastvit_sa12.hef ${D}/usr/local/hailo/resources/models/${HAILO_DEVICE}/
    install -m 0644 ${WORKDIR}/yolov8m.hef ${D}/usr/local/hailo/resources/models/${HAILO_DEVICE}/
    install -m 0644 ${WORKDIR}/yolov8s_pose.hef ${D}/usr/local/hailo/resources/models/${HAILO_DEVICE}/
    install -m 0644 ${WORKDIR}/fcn8_resnet_v1_18.hef ${D}/usr/local/hailo/resources/models/${HAILO_DEVICE}/
    install -m 0644 ${WORKDIR}/yolov5m_seg.hef ${D}/usr/local/hailo/resources/models/${HAILO_DEVICE}/
    install -m 0644 ${WORKDIR}/scdepthv3.hef ${D}/usr/local/hailo/resources/models/${HAILO_DEVICE}/
    install -m 0644 ${WORKDIR}/yolo11s_obb.hef ${D}/usr/local/hailo/resources/models/${HAILO_DEVICE}/
    
    # CLIP Specific installations
    install -m 0644 ${WORKDIR}/bpe_simple_vocab_16e6.txt ${D}/hailo-apps/zero_shot_classification/
    install -m 0644 ${WORKDIR}/embedding_weights.npy ${D}/hailo-apps/zero_shot_classification/ViT-L-14_laion2b_s32b_b82k.npy
    install -m 0644 ${WORKDIR}/text_projection.bin ${D}/hailo-apps/zero_shot_classification/
    install -m 0644 ${WORKDIR}/clip_vit_l_14_laion2B_image_encoder.hef ${D}/hailo-apps/zero_shot_classification/
    install -m 0644 ${WORKDIR}/clip_text_encoder_vit_l_14_laion2B.hef ${D}/hailo-apps/zero_shot_classification/

    for app in ${HAILO_CPP_APPS}; do
        bld_dir="${WORKDIR}/build/${app}"
        install -d ${D}/hailo-apps/${app}

        # assume the built binary is ${bld_dir}/${app}
        bin_path="${bld_dir}/${app}"
        if [ ! -x "${bin_path}" ]; then
            # fallback: find first executable in the build dir (useful if generator lays out differently)
            cand=$(find "${bld_dir}" -maxdepth 1 -type f -perm -u+x | head -n 1 || true)
            if [ -z "${cand}" ]; then
                bbfatal "Could not locate built binary for ${app} (expected ${bin_path})"
            fi
            bin_path="${cand}"
        fi

        install -m 0755 "${bin_path}" "${D}/hailo-apps/${app}/$(basename "${bin_path}")"
    done
}

FILES:${PN} += "\
    /hailo-apps/* \
    /usr/local/hailo/* \
"

# Don't fail if package is empty (for testing)
ALLOW_EMPTY:${PN} = "0"

# Needed to apply the patch correctly
S = "${WORKDIR}/git"
