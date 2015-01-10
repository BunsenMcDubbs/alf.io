/**
 * This file is part of alf.io.
 *
 * alf.io is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * alf.io is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with alf.io.  If not, see <http://www.gnu.org/licenses/>.
 */
package alfio.model.modification;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import alfio.model.PromoCode.DiscountType;

@Getter
public class PromoCodeModification {

	private final String promoCode;
	private final DateTimeModification start;
	private final DateTimeModification end;
	private final int discountAmount;
	private final DiscountType discountType;

	@JsonCreator
	public PromoCodeModification(@JsonProperty("promoCode") String promoCode,
			@JsonProperty("start") DateTimeModification start,
			@JsonProperty("end") DateTimeModification end,
			@JsonProperty("discountAmount") int discountAmount,
			@JsonProperty("discountType") DiscountType discountType) {
		this.promoCode = promoCode;
		this.start = start;
		this.end = end;
		this.discountAmount = discountAmount;
		this.discountType = discountType;	
	}
}