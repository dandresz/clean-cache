export interface CleanCachePlugin {
  clearCache(): Promise<void>;
  optimizeDevice(): Promise<void>;
}
