// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: im.proto

package com.yjlan.im.common.proto;

/**
 * Protobuf type {@code GroupMessageSendRequest}
 */
public  final class GroupMessageSendRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:GroupMessageSendRequest)
    GroupMessageSendRequestOrBuilder {
  // Use GroupMessageSendRequest.newBuilder() to construct.
  private GroupMessageSendRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GroupMessageSendRequest() {
    senderId_ = 0L;
    groupId_ = 0L;
    sendContent_ = "";
    timeStamp_ = 0L;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private GroupMessageSendRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 8: {

            senderId_ = input.readInt64();
            break;
          }
          case 16: {

            groupId_ = input.readInt64();
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            sendContent_ = s;
            break;
          }
          case 32: {

            timeStamp_ = input.readInt64();
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.yjlan.im.common.proto.Im.internal_static_GroupMessageSendRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.yjlan.im.common.proto.Im.internal_static_GroupMessageSendRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.yjlan.im.common.proto.GroupMessageSendRequest.class, com.yjlan.im.common.proto.GroupMessageSendRequest.Builder.class);
  }

  public static final int SENDERID_FIELD_NUMBER = 1;
  private long senderId_;
  /**
   * <code>optional int64 senderId = 1;</code>
   */
  public long getSenderId() {
    return senderId_;
  }

  public static final int GROUPID_FIELD_NUMBER = 2;
  private long groupId_;
  /**
   * <code>optional int64 groupId = 2;</code>
   */
  public long getGroupId() {
    return groupId_;
  }

  public static final int SENDCONTENT_FIELD_NUMBER = 3;
  private volatile java.lang.Object sendContent_;
  /**
   * <code>optional string sendContent = 3;</code>
   */
  public java.lang.String getSendContent() {
    java.lang.Object ref = sendContent_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      sendContent_ = s;
      return s;
    }
  }
  /**
   * <code>optional string sendContent = 3;</code>
   */
  public com.google.protobuf.ByteString
      getSendContentBytes() {
    java.lang.Object ref = sendContent_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      sendContent_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TIMESTAMP_FIELD_NUMBER = 4;
  private long timeStamp_;
  /**
   * <code>optional int64 timeStamp = 4;</code>
   */
  public long getTimeStamp() {
    return timeStamp_;
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (senderId_ != 0L) {
      output.writeInt64(1, senderId_);
    }
    if (groupId_ != 0L) {
      output.writeInt64(2, groupId_);
    }
    if (!getSendContentBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, sendContent_);
    }
    if (timeStamp_ != 0L) {
      output.writeInt64(4, timeStamp_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (senderId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, senderId_);
    }
    if (groupId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(2, groupId_);
    }
    if (!getSendContentBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, sendContent_);
    }
    if (timeStamp_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(4, timeStamp_);
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.yjlan.im.common.proto.GroupMessageSendRequest)) {
      return super.equals(obj);
    }
    com.yjlan.im.common.proto.GroupMessageSendRequest other = (com.yjlan.im.common.proto.GroupMessageSendRequest) obj;

    boolean result = true;
    result = result && (getSenderId()
        == other.getSenderId());
    result = result && (getGroupId()
        == other.getGroupId());
    result = result && getSendContent()
        .equals(other.getSendContent());
    result = result && (getTimeStamp()
        == other.getTimeStamp());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    hash = (37 * hash) + SENDERID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getSenderId());
    hash = (37 * hash) + GROUPID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getGroupId());
    hash = (37 * hash) + SENDCONTENT_FIELD_NUMBER;
    hash = (53 * hash) + getSendContent().hashCode();
    hash = (37 * hash) + TIMESTAMP_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getTimeStamp());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.yjlan.im.common.proto.GroupMessageSendRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.yjlan.im.common.proto.GroupMessageSendRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.yjlan.im.common.proto.GroupMessageSendRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.yjlan.im.common.proto.GroupMessageSendRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.yjlan.im.common.proto.GroupMessageSendRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.yjlan.im.common.proto.GroupMessageSendRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.yjlan.im.common.proto.GroupMessageSendRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.yjlan.im.common.proto.GroupMessageSendRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.yjlan.im.common.proto.GroupMessageSendRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.yjlan.im.common.proto.GroupMessageSendRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.yjlan.im.common.proto.GroupMessageSendRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code GroupMessageSendRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:GroupMessageSendRequest)
      com.yjlan.im.common.proto.GroupMessageSendRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.yjlan.im.common.proto.Im.internal_static_GroupMessageSendRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.yjlan.im.common.proto.Im.internal_static_GroupMessageSendRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.yjlan.im.common.proto.GroupMessageSendRequest.class, com.yjlan.im.common.proto.GroupMessageSendRequest.Builder.class);
    }

    // Construct using com.yjlan.im.common.proto.GroupMessageSendRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      senderId_ = 0L;

      groupId_ = 0L;

      sendContent_ = "";

      timeStamp_ = 0L;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.yjlan.im.common.proto.Im.internal_static_GroupMessageSendRequest_descriptor;
    }

    public com.yjlan.im.common.proto.GroupMessageSendRequest getDefaultInstanceForType() {
      return com.yjlan.im.common.proto.GroupMessageSendRequest.getDefaultInstance();
    }

    public com.yjlan.im.common.proto.GroupMessageSendRequest build() {
      com.yjlan.im.common.proto.GroupMessageSendRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.yjlan.im.common.proto.GroupMessageSendRequest buildPartial() {
      com.yjlan.im.common.proto.GroupMessageSendRequest result = new com.yjlan.im.common.proto.GroupMessageSendRequest(this);
      result.senderId_ = senderId_;
      result.groupId_ = groupId_;
      result.sendContent_ = sendContent_;
      result.timeStamp_ = timeStamp_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.yjlan.im.common.proto.GroupMessageSendRequest) {
        return mergeFrom((com.yjlan.im.common.proto.GroupMessageSendRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.yjlan.im.common.proto.GroupMessageSendRequest other) {
      if (other == com.yjlan.im.common.proto.GroupMessageSendRequest.getDefaultInstance()) return this;
      if (other.getSenderId() != 0L) {
        setSenderId(other.getSenderId());
      }
      if (other.getGroupId() != 0L) {
        setGroupId(other.getGroupId());
      }
      if (!other.getSendContent().isEmpty()) {
        sendContent_ = other.sendContent_;
        onChanged();
      }
      if (other.getTimeStamp() != 0L) {
        setTimeStamp(other.getTimeStamp());
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.yjlan.im.common.proto.GroupMessageSendRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.yjlan.im.common.proto.GroupMessageSendRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private long senderId_ ;
    /**
     * <code>optional int64 senderId = 1;</code>
     */
    public long getSenderId() {
      return senderId_;
    }
    /**
     * <code>optional int64 senderId = 1;</code>
     */
    public Builder setSenderId(long value) {
      
      senderId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int64 senderId = 1;</code>
     */
    public Builder clearSenderId() {
      
      senderId_ = 0L;
      onChanged();
      return this;
    }

    private long groupId_ ;
    /**
     * <code>optional int64 groupId = 2;</code>
     */
    public long getGroupId() {
      return groupId_;
    }
    /**
     * <code>optional int64 groupId = 2;</code>
     */
    public Builder setGroupId(long value) {
      
      groupId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int64 groupId = 2;</code>
     */
    public Builder clearGroupId() {
      
      groupId_ = 0L;
      onChanged();
      return this;
    }

    private java.lang.Object sendContent_ = "";
    /**
     * <code>optional string sendContent = 3;</code>
     */
    public java.lang.String getSendContent() {
      java.lang.Object ref = sendContent_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        sendContent_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string sendContent = 3;</code>
     */
    public com.google.protobuf.ByteString
        getSendContentBytes() {
      java.lang.Object ref = sendContent_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        sendContent_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string sendContent = 3;</code>
     */
    public Builder setSendContent(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      sendContent_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string sendContent = 3;</code>
     */
    public Builder clearSendContent() {
      
      sendContent_ = getDefaultInstance().getSendContent();
      onChanged();
      return this;
    }
    /**
     * <code>optional string sendContent = 3;</code>
     */
    public Builder setSendContentBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      sendContent_ = value;
      onChanged();
      return this;
    }

    private long timeStamp_ ;
    /**
     * <code>optional int64 timeStamp = 4;</code>
     */
    public long getTimeStamp() {
      return timeStamp_;
    }
    /**
     * <code>optional int64 timeStamp = 4;</code>
     */
    public Builder setTimeStamp(long value) {
      
      timeStamp_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int64 timeStamp = 4;</code>
     */
    public Builder clearTimeStamp() {
      
      timeStamp_ = 0L;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:GroupMessageSendRequest)
  }

  // @@protoc_insertion_point(class_scope:GroupMessageSendRequest)
  private static final com.yjlan.im.common.proto.GroupMessageSendRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.yjlan.im.common.proto.GroupMessageSendRequest();
  }

  public static com.yjlan.im.common.proto.GroupMessageSendRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GroupMessageSendRequest>
      PARSER = new com.google.protobuf.AbstractParser<GroupMessageSendRequest>() {
    public GroupMessageSendRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new GroupMessageSendRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GroupMessageSendRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GroupMessageSendRequest> getParserForType() {
    return PARSER;
  }

  public com.yjlan.im.common.proto.GroupMessageSendRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

