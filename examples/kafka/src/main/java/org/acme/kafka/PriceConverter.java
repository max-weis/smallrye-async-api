package org.acme.kafka;

import javax.enterprise.context.ApplicationScoped;

import de.openknowledge.okprofile.asyncapi.annotations.channel.ChannelItem;
import de.openknowledge.okprofile.asyncapi.annotations.message.Message;
import de.openknowledge.okprofile.asyncapi.annotations.operation.Operation;
import de.openknowledge.okprofile.asyncapi.annotations.schema.Schema;
import de.openknowledge.okprofile.asyncapi.annotations.schema.SchemaType;
import org.eclipse.microprofile.reactive.messaging.Acknowledgment;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.smallrye.reactive.messaging.annotations.Broadcast;

/**
 * A bean consuming data from the "prices" Kafka topic and applying some conversion.
 * The result is pushed to the "my-data-stream" stream which is an in-memory stream.
 */
@ApplicationScoped
public class PriceConverter {

    private static final double CONVERSION_RATE = 0.88;

    @ChannelItem(
        channel = "prices",
        subscribe = @Operation(
            operationId = "prices",
            message = @Message(
                contentType = "text/plain",
                summary = "A random price",
                payload = @Schema(
                    type = SchemaType.NUMBER,
                    name = "price",
                    minimum = "0",
                    maximum = "100"
                ),
                example = {"42.24", "17.6", "87.12"}
            )
        )
    )
    @Incoming("prices")
    @Outgoing("my-data-stream")
    @Broadcast
    @Acknowledgment(Acknowledgment.Strategy.PRE_PROCESSING)
    public double process(int priceInUsd) {
        return priceInUsd * CONVERSION_RATE;
    }
}
