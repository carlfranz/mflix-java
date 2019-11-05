package mflix.api.models;

import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.types.ObjectId;

public class StringObjectIdCodec implements Codec<String> {

  @Override
  public String decode(BsonReader reader, DecoderContext decoderContext) {
    return reader.readObjectId()
	.toHexString();
  }

  @Override
  public void encode(BsonWriter writer, String s, EncoderContext encoderContext) {
    writer.writeObjectId(new ObjectId(s));
  }

  @Override
  public Class<String> getEncoderClass() {
    return String.class;
  }

}