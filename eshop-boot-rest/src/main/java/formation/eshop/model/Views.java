package formation.eshop.model;

public class Views {
	public static class ViewCommon {}
	
	public static class ViewAdresse extends ViewCommon {}
	
	public static class ViewPersonne extends ViewCommon {}
	
	public static class ViewFournisseur extends ViewPersonne {}
	
	public static class ViewFournisseurDetail extends ViewFournisseur {}
	
	public static class ViewProduit extends ViewCommon {}
	
	public static class ViewProduitDetail extends ViewProduit {}
}
