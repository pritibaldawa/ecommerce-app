package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class Item {

	private Product product;
	private Integer quantity;

	/*
	 * @Override public int hashCode() { final int prime = 31; int result = 1;
	 * result = prime * result + ((product == null) ? 0 : product.hashCode());
	 * return result; }
	 * 
	 * @Override public boolean equals(Object obj) { if (this == obj) return true;
	 * if (obj == null) return false; if (getClass() != obj.getClass()) return
	 * false; Item other = (Item) obj; if (product == null) { if (other.product !=
	 * null) return false; } else if (!product.equals(other.product)) return false;
	 * if (quantity == null) { if (other.quantity != null) return false; } else if
	 * (!quantity.equals(other.quantity)) return false; return true; }
	 */
}
