package pet.domain;

import com.akkaserverless.javasdk.valueentity.ValueEntityContext;
import com.akkaserverless.javasdk.valueentity.ValueEntityOptions;
import com.akkaserverless.javasdk.valueentity.ValueEntityProvider;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Empty;
import com.google.protobuf.EmptyProto;
import pet.api.PetApi;

import java.util.function.Function;

// This code is managed by Akka Serverless tooling.
// It will be re-generated to reflect any changes to your protobuf definitions.
// DO NOT EDIT

/**
 * A value entity provider that defines how to register and create the entity for
 * the Protobuf service <code>PetService</code>.
 *
 * Should be used with the <code>register</code> method in {@link com.akkaserverless.javasdk.AkkaServerless}.
 */
public class PetProvider implements ValueEntityProvider<PetDomain.PetState, Pet> {

  private final Function<ValueEntityContext, Pet> entityFactory;
  private final ValueEntityOptions options;

  /** Factory method of PetProvider */
  public static PetProvider of(Function<ValueEntityContext, Pet> entityFactory) {
    return new PetProvider(entityFactory, ValueEntityOptions.defaults());
  }
 
  private PetProvider(
      Function<ValueEntityContext, Pet> entityFactory,
      ValueEntityOptions options) {
    this.entityFactory = entityFactory;
    this.options = options;
  }

  @Override
  public final ValueEntityOptions options() {
    return options;
  }
 
  public final PetProvider withOptions(ValueEntityOptions options) {
    return new PetProvider(entityFactory, options);
  }

  @Override
  public final Descriptors.ServiceDescriptor serviceDescriptor() {
    return PetApi.getDescriptor().findServiceByName("PetService");
  }

  @Override
  public final String entityType() {
    return "pets";
  }

  @Override
  public final PetRouter newRouter(ValueEntityContext context) {
    return new PetRouter(entityFactory.apply(context));
  }

  @Override
  public final Descriptors.FileDescriptor[] additionalDescriptors() {
    return new Descriptors.FileDescriptor[] {
      EmptyProto.getDescriptor(),
      PetApi.getDescriptor(),
      PetDomain.getDescriptor()
    };
  }
}
