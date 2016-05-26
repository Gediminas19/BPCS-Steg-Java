I'm Shin-Yi, and my AP Comp Sci Final Project is BPCS Steganography!!

BPCS stands for  Bit-Plane Complexity Segmentation Steganography. This algorithm was developed by Eiji Kawaguchi and Richard O. Eason at the Kyushu Institute of Technology, and a brief PDF describing it is also in the "Professional Papers" folder. This method is very efficient at storing more data than the traditional Least Significant Bit (LSB) algorithm for steganography, while ensuring that modified images are indistinguishable from the original.

The implementation is inspired by the paper "Comparing Steganography Algorithms" by Dr. Rosanne English, which is saved as a PDF in the same folder as the previous document. Chapter 8 contained the most information for how BPCS implementation works specifically, while Chapter 6 Section 2 described how to store "Header" data recording the file size and extension. However, the paper does not have any source code, and I didn't completely agree with the implementation the paper described, so I wrote my code entirely from scratch.

To use it, open the BlueJ package file and use the Hider and Extractor classes only. Use Hider to hide files inside images, and use Extractor to extract files from images. It is highly recommended to use only PNGs for the images.
