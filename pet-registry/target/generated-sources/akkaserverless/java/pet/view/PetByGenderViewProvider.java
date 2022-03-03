package pet.view;

import com.akkaserverless.javasdk.view.ViewCreationContext;
import com.akkaserverless.javasdk.view.ViewOptions;
import com.akkaserverless.javasdk.view.ViewProvider;
import com.google.protobuf.Descriptors;
import pet.domain.PetDomain;

import java.util.function.Function;

// This code is managed by Akka Serverless tooling.
// It will be re-generated to reflect any changes to your protobuf definitions.
// DO NOT EDIT

public class PetByGenderViewProvider implements ViewProvider<PetDomain.PetState, PetByGenderView> {

  private final Function<ViewCreationContext, PetByGenderView> viewFactory;
  private final String viewId;
  private final ViewOptions options;

  /** Factory method of PetByGenderView */
  public static PetByGenderViewProvider of(
      Function<ViewCreationContext, PetByGenderView> viewFactory) {
    return new PetByGenderViewProvider(viewFactory, "PetByGender", ViewOptions.defaults());
  }

  private PetByGenderViewProvider(
      Function<ViewCreationContext, PetByGenderView> viewFactory,
      String viewId,
      ViewOptions options) {
    this.viewFactory = viewFactory;
    this.viewId = viewId;
    this.options = options;
  }

  @Override
  public String viewId() {
    return viewId;
  }

  @Override
  public final ViewOptions options() {
    return options;
  }

  public final PetByGenderViewProvider withOptions(ViewOptions options) {
    return new PetByGenderViewProvider(viewFactory, viewId, options);
  }

  /**
   * Use a custom view identifier. By default, the viewId is the same as the proto service name.
   * A different identifier can be needed when making rolling updates with changes to the view definition.
   */
  public PetByGenderViewProvider withViewId(String viewId) {
    return new PetByGenderViewProvider(viewFactory, viewId, options);
  }

  @Override
  public final Descriptors.ServiceDescriptor serviceDescriptor() {
    return PetViewModel.getDescriptor().findServiceByName("PetByGender");
  }

  @Override
  public final PetByGenderViewRouter newRouter(ViewCreationContext context) {
    return new PetByGenderViewRouter(viewFactory.apply(context));
  }

  @Override
  public final Descriptors.FileDescriptor[] additionalDescriptors() {
    return new Descriptors.FileDescriptor[] {PetViewModel.getDescriptor()};
  }
}

