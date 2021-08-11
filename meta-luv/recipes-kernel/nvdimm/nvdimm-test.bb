DESCRIPTION = "nvdimm tests"
HOMEPAGE = "https://www.kernel.org/pub/linux/kernel"
SECTION = "base"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${STAGING_KERNEL_DIR}/COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"
KBRANCH="stable"

inherit module

SRC_URI = "file://Makefile"

S = "${WORKDIR}"

EXTRA_OEMAKE += "KERNEL=${STAGING_KERNEL_DIR}"
KERNEL_MODULE_PACKAGE_PREFIX = "nvdimm-test"

do_install_prepend() {
        cp ${STAGING_KERNEL_DIR}/tools/testing/nvdimm/Module.symvers ${B}
}

do_populate_lic[depends] += "virtual/kernel:do_populate_lic"

RPROVIDES_${PN} = "kernel-module-libnvdimm"
