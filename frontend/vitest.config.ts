import { defineConfig } from 'vitest/config';

export default defineConfig({
  test: {
    globals: true,
    environment: 'jsdom',
    setupFiles: './vitest-setup.ts',
    coverage: {
      provider: 'v8',          // obligatoire, sinon Vitest se plaint
      reporter: ['text', 'lcov'] as const, // 'as const' fixe le typage
    },
  },
});
