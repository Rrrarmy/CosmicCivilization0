COSMIC CIVILIZATION — GitHub Actions build starter

This is a source project, not a prebuilt .jar. It has not been compiled or tested.
Minecraft 26.2 support must be verified against the exact Fabric Loader, Loom, Minecraft mappings, and Fabric API versions available when you build.

IMPORTANT CORRECTION:
The earlier starter source used an unverified Loom version, no Gradle Wrapper, and an unconfirmed API dependency. This bundle improves the online build workflow but is still a starter and may need API/version adjustments before a successful build.

On GitHub:
1. Create a new repository named CosmicCivilization.
2. Upload the contents of this ZIP (not the ZIP itself) to the repository root.
3. Open Actions and run "Build Cosmic Civilization".
4. If it fails, open the run and read the first error. Do not download a JAR unless the build succeeds.
5. If it succeeds, open the run, scroll to Artifacts, and download cosmic-civilization-jar.

This prototype is only intended as a first command demo:
- /cosmic rocket attempts to create a decorative block rocket
- /cosmic space is a placeholder message
It does NOT yet implement a real rocket entity, dimensions, solar system, or gravity.
