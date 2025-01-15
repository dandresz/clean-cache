export interface CleanCachePlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
