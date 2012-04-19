package datastructure;

import utils.CreateUtils;

public class BitMap {

	int[] map;

	public BitMap(int largest) {
		int length = (largest & 0x1F) == 0 ? largest >> 5 : (largest >> 5) + 1;
		map = new int[length];
		System.out.println("a BitMap for saving " + largest
				+ " numbers is created");
		System.out.println("the map takes " + length
				+ " 32-bit integers and costs " + (int) Math.ceil(largest >> 3)
				+ " bytes memory space");
	}

	public boolean contains(int n) {
		return get(n);
	}

	public boolean get(int n) {
		int index = n >> 5;
		int offset = n & 0x1F;
		return ((map[index] >> offset) & 1) == 1;
	}

	public boolean set(int n) {
		int index = n >> 5;
		int offset = n & 0x1F;
		int t = (map[index] >> offset) & 1;
		map[index] |= 1 << offset;
		return t == 1;
	}

	public static void main(String[] args) {
		int largest = CreateUtils.randomNonNegative(100000);
		BitMap map = new BitMap(largest);
		for (int i = 0; i < largest / 100; i++) {
			int n = CreateUtils.randomNonNegative(largest);
			if (map.contains(n)) {
				System.out.println(n + " was contained in the map");
			} else {
				map.set(n);
				System.out.println(n + " was put into the map");
			}
		}
	}

}
