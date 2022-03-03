package pet.domain;

import com.akkaserverless.javasdk.impl.effect.MessageReplyImpl;
import com.akkaserverless.javasdk.impl.effect.SecondaryEffectImpl;
import com.akkaserverless.javasdk.impl.valueentity.ValueEntityEffectImpl;
import com.akkaserverless.javasdk.testkit.ValueEntityResult;
import com.akkaserverless.javasdk.testkit.impl.TestKitValueEntityContext;
import com.akkaserverless.javasdk.testkit.impl.ValueEntityResultImpl;
import com.akkaserverless.javasdk.valueentity.ValueEntity;
import com.akkaserverless.javasdk.valueentity.ValueEntityContext;
import com.google.protobuf.Empty;
import pet.api.PetApi;

import java.util.function.Function;

// This code is managed by Akka Serverless tooling.
// It will be re-generated to reflect any changes to your protobuf definitions.
// DO NOT EDIT

/**
 * TestKit for unit testing Pet
 */
public final class PetTestKit {

  private PetDomain.PetState state;
  private Pet entity;

  /**
   * Create a testkit instance of Pet
   * @param entityFactory A function that creates a Pet based on the given ValueEntityContext,
   *                      a default entity id is used.
   */
  public static PetTestKit of(Function<ValueEntityContext, Pet> entityFactory) {
    return of("testkit-entity-id", entityFactory);
  }

  /**
   * Create a testkit instance of Pet with a specific entity id.
   */
  public static PetTestKit of(String entityId, Function<ValueEntityContext, Pet> entityFactory) {
    return new PetTestKit(entityFactory.apply(new TestKitValueEntityContext(entityId)));
  }

  /** Construction is done through the static PetTestKit.of-methods */
  private PetTestKit(Pet entity) {
    this.state = entity.emptyState();
    this.entity = entity;
  }

  private PetTestKit(Pet entity, PetDomain.PetState state) {
    this.state = state;
    this.entity = entity;
  }

  /**
   * @return The current state of the Pet under test
   */
  public PetDomain.PetState getState() {
    return state;
  }

  private <Reply> ValueEntityResult<Reply> interpretEffects(ValueEntity.Effect<Reply> effect) {
    @SuppressWarnings("unchecked")
    ValueEntityResultImpl<Reply> result = new ValueEntityResultImpl<>(effect);
    if (result.stateWasUpdated()) {
      this.state = (PetDomain.PetState) result.getUpdatedState();
    }
    return result;
  }

  public ValueEntityResult<Empty> newAdoption(PetApi.Pet pet) {
    ValueEntity.Effect<Empty> effect = entity.newAdoption(state, pet);
    return interpretEffects(effect);
  }

  public ValueEntityResult<PetApi.Pet> retrievePetDetails(PetApi.GetPetRequest getPetRequest) {
    ValueEntity.Effect<PetApi.Pet> effect = entity.retrievePetDetails(state, getPetRequest);
    return interpretEffects(effect);
  }

  public ValueEntityResult<Empty> editPetType(PetApi.ChangeAnimalTypeRequest changeAnimalTypeRequest) {
    ValueEntity.Effect<Empty> effect = entity.editPetType(state, changeAnimalTypeRequest);
    return interpretEffects(effect);
  }

  public ValueEntityResult<Empty> editPetGender(PetApi.ChangeGenderRequest changeGenderRequest) {
    ValueEntity.Effect<Empty> effect = entity.editPetGender(state, changeGenderRequest);
    return interpretEffects(effect);
  }

  public ValueEntityResult<Empty> editAdopterName(PetApi.ChangeAdopterNameRequest changeAdopterNameRequest) {
    ValueEntity.Effect<Empty> effect = entity.editAdopterName(state, changeAdopterNameRequest);
    return interpretEffects(effect);
  }

  public ValueEntityResult<Empty> editAdopterAddress(PetApi.ChangeAdopterAddressRequest changeAdopterAddressRequest) {
    ValueEntity.Effect<Empty> effect = entity.editAdopterAddress(state, changeAdopterAddressRequest);
    return interpretEffects(effect);
  }
}
