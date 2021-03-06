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
package alfio.model;

import ch.digitalfondue.npjt.ConstructorAnnotationRowMapper.Column;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
public class AdditionalServiceItem {

    public enum AdditionalServiceItemStatus {
        FREE, PENDING, TO_BE_PAID, ACQUIRED, CANCELLED, CHECKED_IN, EXPIRED, INVALIDATED, RELEASED
    }

    private final int id;
    private final String uuid;
    private final ZonedDateTime utcCreation;
    private final ZonedDateTime utcLastModified;
    private final String ticketsReservationUuid;
    private final int additionalServiceId;
    private final Integer originalPriceInCents;
    private final Integer paidPriceInCents;
    private final AdditionalServiceItemStatus status;
    private final int eventId;

    public AdditionalServiceItem(@Column("id") int id,
                                 @Column("uuid") String uuid,
                                 @Column("creation") ZonedDateTime utcCreation,
                                 @Column("last_modified") ZonedDateTime utcLastModified,
                                 @Column("tickets_reservation_uuid") String ticketsReservationUuid,
                                 @Column("additional_service_id_fk") int additionalServiceId,
                                 @Column("original_price_cts") Integer originalPriceInCents,
                                 @Column("paid_price_cts") Integer paidPriceInCents,
                                 @Column("status") AdditionalServiceItemStatus status,
                                 @Column("event_id_fk") int eventId) {
        this.id = id;
        this.uuid = uuid;
        this.utcCreation = utcCreation;
        this.utcLastModified = utcLastModified;
        this.ticketsReservationUuid = ticketsReservationUuid;
        this.additionalServiceId = additionalServiceId;
        this.originalPriceInCents = originalPriceInCents;
        this.paidPriceInCents = paidPriceInCents;
        this.status = status;
        this.eventId = eventId;
    }
}
