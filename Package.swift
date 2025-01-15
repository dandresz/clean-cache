// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "DanielCleanCache",
    platforms: [.iOS(.v13)],
    products: [
        .library(
            name: "DanielCleanCache",
            targets: ["CleanCachePlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", branch: "main")
    ],
    targets: [
        .target(
            name: "CleanCachePlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/CleanCachePlugin"),
        .testTarget(
            name: "CleanCachePluginTests",
            dependencies: ["CleanCachePlugin"],
            path: "ios/Tests/CleanCachePluginTests")
    ]
)