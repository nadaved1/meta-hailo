# This patch was written off onnxruntime 1.17.1
# Disable unit tests to reduce build time
EXTRA_OECMAKE += "-Donnxruntime_BUILD_UNIT_TESTS=OFF"

ORT_TESTS = "\
    onnxruntime_mlas_test \
    onnxruntime_global_thread_pools_test \
    onnxruntime_shared_lib_test \
    testdata \
"

# Create dummy files for hardcoded installation steps in the meta-imx recipe
do_install:prepend() {
    touch ${B}/onnxruntime_perf_test
    touch ${B}/onnxruntime_test_all
    touch ${B}/libcustom_op_library.so
    for test in ${ORT_TESTS}; do
        touch ${B}/${test}
    done 
}

do_install:append() {
    # 1. Clean up the dummy test binaries from the target bin directory
    rm -f ${D}${bindir}/onnxruntime_perf_test
    rm -f ${D}${bindir}/onnxruntime_test_all

    # 2. Clean up the dummy sample library from the target lib directory
    rm -f ${D}${libdir}/libcustom_op_library.so
    for test in ${ORT_TESTS}; do
        rm -f ${D}${libdir}/${test}
    done

    # 3. Install the missing C/C++ API headers
    install -d ${D}${includedir}/onnxruntime/core/session
    
    install -m 0644 ${S}/include/onnxruntime/core/session/*.h \
        ${D}${includedir}/onnxruntime/core/session/
}