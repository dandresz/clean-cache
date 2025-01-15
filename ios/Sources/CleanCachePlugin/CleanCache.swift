import Foundation

@objc public class CleanCache: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
