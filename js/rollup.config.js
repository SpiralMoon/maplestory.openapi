import commonjs from '@rollup/plugin-commonjs';
import resolve from '@rollup/plugin-node-resolve';
import { terser } from 'rollup-plugin-terser';
import typescript from 'rollup-plugin-typescript2';
import pkg from './package.json';

const external = [
  ...require('module').builtinModules,
  ...Object.keys(pkg.dependencies || {}),
  ...Object.keys(pkg.peerDependencies || {}),
];

const plugins = [
  resolve(),
  commonjs(),
  typescript({
    useTsconfigDeclarationDir: true,
    tsconfigOverride: {
      exclude: ['test/**/*'],
    },
  }),
];

const moduleBuild = {
  input: {
    index: 'src/index.ts',
    kms: 'src/maplestory/api/kms/index.ts',
    msea: 'src/maplestory/api/msea/index.ts',
  },
  output: [
    {
      dir: 'dist/esm',
      format: 'esm',
      preserveModules: true,
      preserveModulesRoot: 'src',
    },
    {
      dir: 'dist/cjs',
      format: 'cjs',
      preserveModules: true,
      preserveModulesRoot: 'src',
    },
  ],
  external,
  plugins,
};

const umdBuild = {
  input: 'src/index.ts',
  output: {
    name: pkg['umd:name'] || pkg.name,
    format: 'umd',
    file: pkg.unpkg,
    sourcemap: false,
    esModule: false,
    plugins: [terser()],
  },
  external,
  plugins,
};

export default [moduleBuild, umdBuild];
